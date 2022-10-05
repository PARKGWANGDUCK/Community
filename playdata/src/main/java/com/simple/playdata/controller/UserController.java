package com.simple.playdata.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.playdata.command.UsersVO;
import com.simple.playdata.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//로그인화면
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	//가입화면
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	//회원가입
	@GetMapping("/joinForm")
	public String joinForm(UsersVO vo,
						   RedirectAttributes RA) {
		
		int result = userService.join(vo);
		System.out.println(vo.toString());
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "환영합니다");
		} else {
			RA.addFlashAttribute("msg", "가입에 실패했습니다. 관리자에 문의하세요");
		}
		
		return "redirect:/user/login";
	}
	
	@PostMapping("/login")
	public String login(UsersVO vo,
						RedirectAttributes RA,
						HttpSession session) {
		UsersVO userVO = userService.login(vo);
		if(userVO != null) {
			session.setAttribute("userId", userVO.getId());
			session.setAttribute("userName", userVO.getName());
		
			return "redirect:/table/Board";
		} else {
			RA.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			return "redirect:/user/login";
		}
		
	}
	
}
