package com.project2.movieproject.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public void main() {
		
=======
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.main.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/main")
	public String main(Model model) {
		ArrayList<MovieVO> main_banner = mainService.getMainBanner();
		ArrayList<MovieVO> main_rank = mainService.getMainRank();
		ArrayList<MovieVO> main_rankList = mainService.getMainRankList();
		
		model.addAttribute("main_banner", main_banner);
		model.addAttribute("main_rank", main_rank);
		model.addAttribute("main_rankList", main_rankList);
		
		return "main";
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	}
}
