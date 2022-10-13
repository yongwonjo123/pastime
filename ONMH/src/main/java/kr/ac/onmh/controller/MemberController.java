package kr.ac.onmh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.onmh.model.Member;
import kr.ac.onmh.service.MemberService;
import kr.ac.onmh.util.Pager;

//회원을 CRUD 할 수 있는 CONTROLLER
@Controller
@RequestMapping("/member")
public class MemberController {

	final String path = "member/";

	@Autowired
	MemberService ms;
	
	//회원의 리스트를 반환하는 메서드
	@GetMapping("/list")
	public String list(Pager pager, Model model) {
		pager.setPerPage(20);
		List<Member> list = ms.list(pager);
		model.addAttribute("list", list);
		
		return path+"list";
	}
	//회원 1명의 정보를 반환하는 메서드
	@GetMapping("/{id}")
	public String item(@PathVariable String id, Model model) {
		Member item = ms.item(id);
		model.addAttribute("item", item);
		return path+"item";
	}
	
		
	//회원 정보를 가져와서 수정하는 메서드
	@GetMapping("/update/{id}")
	public String update(@PathVariable String id, Model model, HttpSession session, RedirectAttributes ra) {
		Member user = (Member)session.getAttribute("user");
		model.addAttribute("user", user);
		
		Member item = ms.item(id);
		model.addAttribute("item", item);
		
//		다른 회원의 접근 차단.
		if(!item.getId().equals(user.getId())) {
			ra.addFlashAttribute("err_msg", "허용되지 않은 접근입니다.");
			return "redirect:../list";
		}
		
		return path +"update";
	}
	
	//회원 정보를 가져와서 수정하는 메서드
	@PostMapping("/update/{id}")
	public String update(@PathVariable String id, Member item) {
		item.setId(id);
		ms.update(item);
		return "redirect:../list";
	}
	
	
	//회원 정보를 삭제하는 메서드
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, HttpSession session, RedirectAttributes ra) {
		Member item = ms.item(id);
		Member user = (Member)session.getAttribute("user");
		
//		회원이 다른 경우 
		if(!item.getId().equals(user.getId())) {
//			리스트로 보낸다
			ra.addFlashAttribute("err_msg", "작성이와 다른 회원입니다");
			return "redirect:../list";
		}
		
		ms.delete(id);
		return "redirect:../list";
	}

	// ID 중복 체크
	// 아이디 중복 검사
	@ResponseBody
	@GetMapping("/signin/checkId")
	public String checkId(String id) {

		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (ms.checkId(id))
			return "ok";
		else
			return "no";
	}

}
