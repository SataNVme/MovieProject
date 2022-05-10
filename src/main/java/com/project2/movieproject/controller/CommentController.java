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
import com.project2.movieproject.util.CommentCriteria;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	
	//목록 화면
	@GetMapping("/commentList")
	public String commentList(@RequestParam("movie_koficCd") String movie_koficCd,
							  Model model,
							  CommentCriteria commentCri) {
		
		//select 
		commentCri.setMovie_koficCd(movie_koficCd);
		System.out.println(commentCri);
		ArrayList<CommentVO> list = commentService.getList(commentCri);
		model.addAttribute("list", list);
		
		System.out.println(list.toString());
		
//		RA.addAttribute(movie_koficCd);
//		return "redirect:/comment/commentList";
		return "comment/commentList";
		
	}
	
	//코멘트 등록
	@PostMapping("/commentForm")
	public String commentForm(CommentVO vo,
							  RedirectAttributes RA) {
		
		vo.setUser_id(Integer.toString(1));
		
		System.out.println(vo.toString());
		
		int result = commentService.regist(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "리뷰를 등록했습니다.");
		} else {
			RA.addFlashAttribute("msg", "리뷰 등록에 실패했습니다.");
		}
		
		
		RA.addAttribute("movie_koficCd", vo.getComment_mn());
		return "redirect:/movie/movieDetail";
	}
	
	//코멘트 테스트용
	@GetMapping("/commentId")
	public void commentId() {
//		System.out.println(id);
	}
	
	@PostMapping("/testId")
	public String testId(@RequestParam(value = "id") String id,
						RedirectAttributes RA) {
		//System.out.println(id);
		RA.addFlashAttribute("id", id);
		return "redirect:/comment/commentList";
	}
	
	

}
