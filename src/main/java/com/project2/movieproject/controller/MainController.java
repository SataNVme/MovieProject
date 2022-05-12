package com.project2.movieproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.UserVO;
import com.project2.movieproject.main.MainService;
import com.project2.movieproject.user.UserService;

@Controller
@SessionAttributes("vo")
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@ModelAttribute("vo")
	public UserVO setUserVO() {
		System.out.println("***********setUserVO()**********");
		return new UserVO();
	}
	
	
	@GetMapping("main")
	public String main(Model model, @ModelAttribute("vo") UserVO vo) {
		ArrayList<MovieVO> main_banner = mainService.getMainBanner();
		ArrayList<MovieVO> main_rank = mainService.getMainRank();
		ArrayList<MovieVO> main_rankList = mainService.getMainRankList();
		
		model.addAttribute("main_banner", main_banner);
		model.addAttribute("main_rank", main_rank);
		model.addAttribute("main_rankList", main_rankList);
		if(vo.getUser_id() != null) {
			model.addAttribute("vo", vo);
		}
		return "main";
	}
	
}
