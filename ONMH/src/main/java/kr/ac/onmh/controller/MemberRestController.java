package kr.ac.onmh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.onmh.model.Member;
import kr.ac.onmh.service.MemberService;
import kr.ac.onmh.util.Pager;



@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	@Autowired
	MemberService service;

	@GetMapping
	public Map<String, Object> list(Pager pager){
		List<Member> list = service.list(pager);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pager", pager);
		if(list == null)
			map.put("msg", String.format("member list : list is null"));
		else
			map.put("msg", String.format("member list : ok"));
		
		return map;
	}
	

	@GetMapping("/item")
	public Map<String, Object> item(String id) {
		Member item = service.item(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", item);
		
		if(item == null)
			map.put("msg", String.format("member %s item : member is null", id));
		else
			map.put("msg", String.format("member %s item : ok", id));
		
		return map; 
	}


		@GetMapping("/find")
		public Map<String, Object> findId(String email){
			Map<String, Object> map = new HashMap<>();
			
			String id = service.findId(email);
			
			if(id == null || id.equals("")) {
				map.put("msg", String.format("%s에 해당하는 아이디가 없습니다.", email));
			}
			else {
				map.put("id", id);
				map.put("msg", "찾는데 성공했습니다.");
			}
			
			return map;
		}
		

		@GetMapping("/confirm/email")
		public String confirmEmail(String email) {
//				이메일에 중복이 없으면
			if (service.confirmEmail(email)) {
//					ok 반환
				return "ok";
			} else {
//					중복이면 no 반환
				return "no";
			}
		}
}
