package com.project2.movieproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.command.CommentVO;
import com.project2.movieproject.comment.CommentService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@GetMapping("/movieComment")
	public void movieComment() {
		
	}
	
	@GetMapping("/movieDetail")
	public void movieDetail() {
		
	}
	
	@GetMapping("/movieList")
	public void movieList() {
		
	}
	
	@GetMapping("/movieBuy")
	public void movieBuy() {
		
	}
	@GetMapping("/movieRent")
	public void movieRent() {
		
	}
	
	
}
