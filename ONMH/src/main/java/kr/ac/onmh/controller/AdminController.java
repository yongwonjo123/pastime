package kr.ac.onmh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.onmh.model.Club;
import kr.ac.onmh.model.Member;
import kr.ac.onmh.model.Thunder;
import kr.ac.onmh.service.ClubService;
import kr.ac.onmh.service.MemberService;
import kr.ac.onmh.service.ThunderService;
import kr.ac.onmh.util.Pager;

@Controller
@RequestMapping("/admin")
public class AdminController {
	final String path = "admin/";
	@Autowired
	MemberService ms;
	@Autowired
	ClubService cs;
	@Autowired
	ThunderService ts;

	// 회원 관리
	@GetMapping("/memberControll")
	public String memberControll(Model model) {
		Pager pager = new Pager();
		List<Member> list = ms.list(pager);
		model.addAttribute("list", list);
		return path + "admin_user";
	}

	//모임 관리
	@GetMapping("/clubControll")
	public String clubControll(Model model) {
		Pager pager = new Pager();
		List<Club> list = cs.list(pager);
		model.addAttribute("list", list);
		return path + "admin_club";
	}
	
	//리뷰 관리
	@GetMapping("/reviewControll")
	public String reviewControll(Model model) {
		Pager pager = new Pager();
		List<Thunder> list = ts.list(pager);
		model.addAttribute("list", list);
		return path + "admin_review";
	}
	
}
