package kr.ac.onmh.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import kr.ac.onmh.model.Club;
import kr.ac.onmh.model.Member;
import kr.ac.onmh.model.Thunder;
import kr.ac.onmh.service.ClubService;
import kr.ac.onmh.service.MemberService;
import kr.ac.onmh.service.ThunderService;
import kr.ac.onmh.util.Pager;

//메인페이지와 로그인 회원가입을 할 수 있는 CONTROLLER
@Controller
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	MemberService ms;
	@Autowired
	ClubService cs;
	@Autowired
	ThunderService ts;
	

	//메인페이지
	@RequestMapping("/")
	public String index(Model model) {
		Pager pager = new Pager();
		pager.setPerPage(8);
		List<Club> list = cs.list(pager);
		List<Thunder> tlist = ts.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("tlist", tlist);
		return "index";
	}
	
	// 회원 가입 화면 요청
	@GetMapping("/signup")
	public String signup() {
		return  "signup";
	}

	// 로그인 화면 요청
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// 회원가입
	@PostMapping("/signup")
	public String registerAction(Member item, RedirectAttributes rtts) {
		ms.add(item);
		rtts.addFlashAttribute("msg", "회원가입이 완료 되었습니다");
		logger.info("회원 가입 완료");
		return "redirect:login";
	}

	//로그인 실행
	@PostMapping("/login")
	public String login(Member item, HttpSession session, HttpServletResponse response, boolean autoLogin, RedirectAttributes ra) {
		// 클라이언트 측에 자동 로그인용 체크박스 추가 -> name="autoLogin"
		
		Member user = ms.login(item);
		
		if(user == null) {
			System.out.println("회원 정보가 없습니다.");
			ra.addFlashAttribute("err_msg", "로그인에 실패했습니다");
			return "redirect:login";
		}
		
		session.setAttribute("user", user);

//		autoLogin - Using Cookie
		if(autoLogin) {
			String sessionId = session.getId();
			ms.keepLogin(sessionId, user.getId());
			
			Cookie cookie = new Cookie("loginCookie", sessionId);
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24 * 1);
			response.addCookie(cookie);
		}
		
		//User Interceptor 처리
		String destPath = (String) session.getAttribute("dest_path");
		if(destPath != null) {
			session.removeAttribute("dest_path");
			return "redirect:"+destPath;
		}
	
		return "redirect:/";
	}
	
	

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, "loginCookie");
		
		if(cookie != null) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			Member user = (Member) session.getAttribute("user");
			ms.keepLogin(null, user.getId());
		}
		
		session.invalidate();
		return "redirect:/";
	}
	
	//회원 정보 찾기
	@GetMapping("/findid")
	public String findId() {
		return "findId";
	}

	// 마이페이지-내 모임
	@GetMapping("/mypage/myclub")
	public String myclub(HttpSession session, Model model) {
		Member user = (Member) session.getAttribute("user");

		model.addAttribute("item", user);

		return "mypage/"+"myclub";
	}

	// 마이페이지-내 정보
	@GetMapping("/mypage/info/{id}")
	public String mypage(@PathVariable String id,HttpSession session, Model model) {
		Member user = (Member) session.getAttribute("user");

		model.addAttribute("item", user);
		return "mypage/" + "info";
	}
	@PostMapping("/mypage/info/{id}")
	public String mypage(@PathVariable String id, Member item) {
		item.setId(id);
		ms.update(item);
		return "redirect:../myclub";
	}

}
