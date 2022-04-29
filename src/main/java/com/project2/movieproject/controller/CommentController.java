package com.project2.movieproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.command.CommentVO;
import com.project2.movieproject.comment.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	
	//목록 화면
	@GetMapping("/commentList")
	public String commentList(Model model) {
		
		ArrayList<CommentVO> list = commentService.getList();
		model.addAttribute("list", list);
		
		System.out.println(list.toString());
		
		return "comment/commentList";
		
	}
	
	//코멘트 등록
	@PostMapping("/commentForm")
	public String commentForm(CommentVO vo,
							  RedirectAttributes RA) {
		
//		System.out.println(vo.toString());
		
		int result = commentService.regist(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "리뷰를 등록했습니다.");
		} else {
			RA.addFlashAttribute("msg", "리뷰 등록에 실패했습니다.");
		}

		return "redirect:/movie/movieDetail";
	}
	
	//코멘트 테스트용
	@GetMapping("/commentId")
	public void commentId() {
		
	}
	
	@PostMapping("/testId")
	public String testId() {
		
		return "redirect:/movie/movieDetail";
	}
	
	

}
