package kr.ac.onmh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.onmh.model.Image;
import kr.ac.onmh.model.Member;
import kr.ac.onmh.model.Thunder;
import kr.ac.onmh.service.ImageService;
import kr.ac.onmh.service.ThunderService;
import kr.ac.onmh.util.FileUploader;
import kr.ac.onmh.util.Pager;

// 사용자를 모임과 관련된 페이지로 이동시키는 Controller

@Controller
@RequestMapping("/thunder")
public class ThunderController {
	final String path = "thunder/";

	@Autowired
	ThunderService service;
	@Autowired
	@Qualifier("ThunderImageService")
	ImageService imageService;
	@Autowired
	FileUploader uploader;

	// 정기 모임 목록
	@GetMapping("/list")
	public String list(Pager pager, Model model) {
		pager.setPerPage(20);
		List<Thunder> list = service.list(pager);
		model.addAttribute("list", list);
		return path + "list";
	}

	// 1개 club 상세 보기
	@GetMapping("/{code}")
	public String view(@PathVariable int code, Model model) {
		Thunder item = service.item(code);
		model.addAttribute("item", item);

		return path + "view";
	}

	// club 등록 페이지로 이동
	@GetMapping("/add")
	public String registerThunder(Model model, HttpSession session, RedirectAttributes ra) {
		Member user = (Member) session.getAttribute("user");

		model.addAttribute("user", user);
		return path + "add";
	}

	// club 정보 추가 (image 업로드 , )
	@PostMapping("/add")
	public String registerThunder(Thunder item, @RequestParam("image") List<MultipartFile> images) {
		List<Image> imageList = uploader.upload(images);
		item.setImages(imageList);
		service.add(item);

		return "redirect:list";
	}

	// club 정보 수정 페이지
	@GetMapping("/update/{code}")
	public String update(@PathVariable int code, Model model, HttpSession session, RedirectAttributes ra) {
		Member user = (Member) session.getAttribute("user");
		model.addAttribute("user", user);

		Thunder item = service.item(code);
		model.addAttribute("item", item);

//		작성이와 로그인한 회원이 다를 경우
		if (!item.getId().equals(user.getId())) {
			ra.addFlashAttribute("err_msg", "작성이와 다른 회원입니다");
			return "redirect:../list";
		}

		return path + "update";
	}

	// club 정보 수정
	@PostMapping("/update/{code}")
	public String update(@PathVariable int code,Thunder item, @RequestParam("image") List<MultipartFile> images) {
		item.setCode(code);
		imageService.delete(item.getCode());

		List<Image> imageList = uploader.upload(images);
		item.setImages(imageList);

		service.update(item);
		return "redirect:../list";
	}

	// club 삭제
	@GetMapping("/delete/{code}")
	public String delete(@PathVariable int code, HttpSession session, RedirectAttributes ra) {
		Thunder item = service.item(code);
		Member user = (Member) session.getAttribute("user");

//		작성이와 로그인한 회원이 다를 경우
		if (!item.getId().equals(user.getId())) {
//			리스트로 보낸다
			ra.addFlashAttribute("err_msg", "작성이와 다른 회원입니다");
			return "redirect:../list";
		}

		imageService.delete(code);
		service.delete(code);
		return "redirect:../list";
	}

}
