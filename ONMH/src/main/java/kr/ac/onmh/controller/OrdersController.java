package kr.ac.onmh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.onmh.model.Club;
import kr.ac.onmh.model.Member;
import kr.ac.onmh.model.OrderedClub;
import kr.ac.onmh.model.Orders;
import kr.ac.onmh.service.ClubService;
import kr.ac.onmh.service.OrdersService;
import kr.ac.onmh.util.ObjectConverter;

//주문과 관련된 일을 하는 CONTROLLER

@Controller
@RequestMapping("/orders")
public class OrdersController {
	final String path = "orders/";
	
	@Autowired
	OrdersService service;
	@Autowired
	ClubService cs;
	@Autowired
	ObjectConverter<OrderedClub> converter;

	@GetMapping("/payment")
	public String payment(@RequestParam(value="ccode", required = false) Integer ccode, 
			@RequestParam(value="amount", required = false) Integer amount,
			Model model, HttpSession session, RedirectAttributes ra) {
//		로그인한 회원을 찾아서
		Member user = (Member) session.getAttribute("user");
		
		if(user != null) {
//			jsp에 전달
//			orders에 id 넣을 때 사용
			model.addAttribute("user", user);
		}
		
//		장바구니에 담은걸 결제할 경우
		if(ccode == null || amount == null ||
			amount < 1) {
//			카트를 찾아서
			Object cart = session.getAttribute("cart");
			List<OrderedClub> clubs = converter.list(cart, OrderedClub.class);
			
//			장바구니가 없을 경우
			if(clubs == null) {
				ra.addFlashAttribute("err_msg", "구매할 상품이 없습니다");
				return "redirect:cart";
			}
			
//			내가 구매를 결정한 것만 걸러내서
			clubs = clubs.stream()
					.filter(item -> item.isChecked())
					.collect(Collectors.toList());
			
			if(clubs.size() > 0) {
//				session에 저장하고 post페이지에서 사용함
				session.setAttribute("payment", clubs);
//				jsp에서 보여주기 위해 설정한다
				int total = cs.priceTotal(clubs);
				List<Club> productList = cs.list(clubs);
				
				int total_amount = 0;
				
				for(Club c : productList) {
					total_amount += c.getAmount();
				}
				
				model.addAttribute("amount", total_amount);
				model.addAttribute("list", productList);
				model.addAttribute("total", total);
			}
			else {
//				결제할 상품이 없을 경우
				ra.addFlashAttribute("err_msg", "구매할 상품이 없습니다");
				return "redirect:cart";
			}
		}
		else {
//			직접 주문한 경우
			List<OrderedClub> clubs = new ArrayList<>();
			OrderedClub OrderedClub = new OrderedClub();
			
			OrderedClub.setCcode(ccode);
			OrderedClub.setAmount(amount);
			OrderedClub.setChecked(true);
			
			clubs.add(OrderedClub);
			
//			결제할 상품을 저장한다
			session.setAttribute("payment", clubs);
			
//			payment 페이지에서 사용할 상품 리스트를 인위적으로 만든다
			List<Club> productList = new ArrayList<>();
			Club club = cs.item(ccode);
			club.setAmount(amount);
			
			productList.add(club);
			
//			payment에서 표시할 정보를 보낸다
			model.addAttribute("amount", amount);
			model.addAttribute("list", productList);
			model.addAttribute("total", club.getAmount()*club.getPrice());
		}
		
		return path+"payment";
	}

	@PostMapping("/payment")
	public String payment(Orders item, HttpSession session, RedirectAttributes ra) {
//		주문한 상품을 꺼내와서
		Object payment = session.getAttribute("payment");
//		orders에 넣는다
		List<OrderedClub> clubs = converter.list(payment, OrderedClub.class);
		item.setClubs(clubs);
		
		if(clubs == null) {
//			장바구니에 상품이 없으면 결제페이지에 오늘 걸 막는다
//			intercepter에 이 기능을 추가할 가능성 있음
			ra.addFlashAttribute("err_msg", "구매할 상품이 없습니다");
			return "redirect:cart";
		}
//		주문이라고 설정
		item.setSubscribe('n');
//		DB에 저장
		service.add(item);

//		주문한 상품 삭제
		session.removeAttribute("payment");
		
//		카트를 찾는다
		Object cart = session.getAttribute("cart");
		
		if(cart != null) {
//			clubs 변수 재사용
			clubs = converter.list(cart, OrderedClub.class);
//			이미 주문한 제품은 걸러낸다
			clubs = clubs.stream()
					.filter(p -> !p.isChecked())
					.collect(Collectors.toList());
//			session에 다시 저장
			session.setAttribute("cart", clubs);
			
		}

		return "redirect:confirm";
	}
	

	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
		Object cart = session.getAttribute("cart");
		
		List<OrderedClub> clubs = converter.list(cart, OrderedClub.class);
		
		int total = 0;
		int count = 0;
		
		if(clubs != null) {
			total = cs.priceTotal(clubs);
			List<Club> productList = cs.list(clubs);
			
			for(OrderedClub op : clubs) {
				if(op.isChecked()) {
					count += op.getAmount();
				}
			}
			
			model.addAttribute("list", productList);
		}
		
		model.addAttribute("total", total);
		model.addAttribute("count", count);
		
		return path+"cart";
	}
	

	@GetMapping("/confirm")
	public String confirm() {
		return path+"confirm";
	
}
}
