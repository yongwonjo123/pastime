package kr.ac.onmh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.onmh.model.OrderedClub;
import kr.ac.onmh.service.ClubService;
import kr.ac.onmh.util.ObjectConverter;


@RestController
@RequestMapping("/rest/cart")
public class CartRestController {
	@Autowired
	ObjectConverter<OrderedClub> converter;
	@Autowired
	ClubService cs;
	

	@PostMapping
	public Map<String, Object> add(OrderedClub item, HttpSession session) {
		Object cart = session.getAttribute("cart");
		
		List<OrderedClub> list = converter.list(cart, OrderedClub.class);
		
		if(list == null) {
			list = new ArrayList<OrderedClub>();
		}
		
		boolean isExist = false;
		
//		중복되는 상품이 있는지 찾는다
		for(OrderedClub p : list) {
			if(p.getCcode() == item.getCcode()) {
//				중복되는 상품이 있으면 수량만 더한다
				isExist = true;
				p.setAmount(p.getAmount() + item.getAmount());
				break;
			}
		}
		
//		중복되는 상품이 없으면 cart에 추가한다
		if(!isExist)
			list.add(item);
		
		session.setAttribute("cart", list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", item);
		map.put("msg", String.format("cart add : product %d ok", item.getCcode()));
		
		return map;
	}
	

	@GetMapping
	public Map<String, Object> list(HttpSession session){		
		Object cart = session.getAttribute("cart");
		List<OrderedClub> list = converter.list(cart, OrderedClub.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		if(list != null)
			map.put("msg", String.format("cart list : ok"));
		else
			map.put("msg", String.format("cart list : cart is null"));
		return map;
	}
	

	@PostMapping("/{ccode}")
	public Map<String, Object> update(@PathVariable int ccode, String type, HttpSession session){
		Object cart = session.getAttribute("cart");
		List<OrderedClub> list = converter.list(cart, OrderedClub.class);
		String msg = String.format("cart update %d : ok", ccode);
		int total = 0;
		int count = 0;
		OrderedClub item = null;
		
//		카트 안에서 찾는다
		for(OrderedClub op : list) {
			if(op.getCcode() == ccode) {
				item = op;
				switch (type) {
				case "increase":
//					수량 증가
					op.setAmount(op.getAmount()+1);
					break;
				case "decrease":
//					수량 감소
					op.setAmount(op.getAmount()-1 <= 1 ? 1 : op.getAmount()-1);
					break;
				default:
//					경고 알림
					msg = String.format("cart update %d : type error %s 타입은 없습니다.", ccode, type);
					break;
				}
			}
			
			if(op.isChecked())
				count += op.getAmount();
		}
		
		session.setAttribute("cart", list);
		
		total = cs.priceTotal(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("msg", msg);
		map.put("amount", item.getAmount());
		map.put("count", count);
		return map;
	}
	
	@DeleteMapping("/{ccode}")
	public Map<String, Object> delete(@PathVariable int ccode, HttpSession session){
		Object cart = session.getAttribute("cart");
		List<OrderedClub> list = converter.list(cart, OrderedClub.class);
		String msg = String.format("cart delete %d : ok", ccode);
		int total = 0;
		int idx = -1;
		int count = 0;
		
//		카트 안에서 찾는다
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCcode() == ccode) {
				idx = i;
			}
			
			if(list.get(i).isChecked())
				count += list.get(i).getAmount();
		}
//		찾을 걸 지운다
		if(idx != -1) {
			if(list.get(idx).isChecked())
				count -= list.get(idx).getAmount();
			list.remove(idx);
		}
		else {
//			실패하면 메세지를 남긴다
			msg = String.format("cart delete %d :  삭제 실패", ccode);
		}
//		다시 카트를 넣는다
		session.setAttribute("cart", list);
//		가격을 구한다
		total = cs.priceTotal(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("msg", msg);
		map.put("count", count);
		return map;
	}
	
//	카트 안에 있는 상품들 중 구매 여부를 수정한다
	@PostMapping("/check/{ccode}")
	public Map<String, Object> checked(@PathVariable int ccode, HttpSession session){
		Object cart = session.getAttribute("cart");
		List<OrderedClub> list = converter.list(cart, OrderedClub.class);
		String msg = String.format("cart checked %d : error 찾는 상품이 없습니다.", ccode);
		int total = 0;
		int count = 0;
		
		for(OrderedClub op : list) {
			if(op.getCcode() == ccode) {
				op.setChecked(!op.isChecked());
				msg = String.format("cart checked %d : ok", ccode);
			}
			
			if(op.isChecked())
				count += op.getAmount();
		}
		
		total = cs.priceTotal(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", msg);
		map.put("item", ccode);
		map.put("total", total);
		map.put("count", count);
		return map;
	}
	
//	카트 안에 있는 상품들 중 구매 여부를 전부 수정한다
	@PostMapping("/check")
	public Map<String, Object> checked(HttpSession session, boolean check){
		Object cart = session.getAttribute("cart");
		List<OrderedClub> list = converter.list(cart, OrderedClub.class);
		String msg = String.format("cart checked all : ok");
		int total = 0;
		int count = 0;
		
		for(OrderedClub op : list) {
			op.setChecked(check);
			
			if(op.isChecked())
				count += op.getAmount();
		}
		
		total = cs.priceTotal(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", msg);
		map.put("total", total);
		map.put("count", count);
		return map;
	}
}
