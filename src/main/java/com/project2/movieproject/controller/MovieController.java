package com.project2.movieproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.command.CommentVO;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.StarRateVO;
import com.project2.movieproject.command.UserVO;
import com.project2.movieproject.comment.CommentService;
import com.project2.movieproject.movieDetail.MovieService;

@Controller
@SessionAttributes("vo")
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	@Qualifier("movieService")
	private MovieService movieService;

	@GetMapping("/movieComment")
	public void movieComment() {
		
	}
	
	@GetMapping("/movieDetail")
	public String movieDetail(@RequestParam("movie_koficCd") String movie_koficCd, 
							  Model model,
							  @ModelAttribute("vo") UserVO sessionvo) {
		
		
		//movie select
		MovieVO movieVo = movieService.getDetail(movie_koficCd);
		
		//유튜브 주소
		String vUrl = movieVo.getMovie_vUrl();
		String url = "https://youtube.com/embed/" + vUrl.substring(32,43);
		
		//코멘트 주소
		String commentUrl = "/comment/commentList?movie_koficCd=" + movie_koficCd;
		model.addAttribute("commentUrl", commentUrl);
		
		//별점
		float starRate = 0;
		if( movieService.getStarRate(movie_koficCd) == null) {
			starRate = 0;
		} else {
			starRate = movieService.getStarRate(movie_koficCd);
		}		
		model.addAttribute("starRate", starRate);
		//리뷰 등록
		model.addAttribute("url", url);
		model.addAttribute("movieVo", movieVo);
		
		//로그인 여부 체크
		int checkLogin;
		
		if (sessionvo.getUser_id() == null) {
			checkLogin = 0;
		} else {
			checkLogin = 1;
		}
		model.addAttribute("checkLogin", checkLogin);
		
		return "movie/movieDetail";
		
	}
	
	@GetMapping("/movieList")
	public String movieList(@RequestParam("nation") String nation,
							Model model) {
		
		String genre;
		if(nation.equals("ko")) {
			genre = "action";
			ArrayList<MovieVO> actionList = movieService.getList_ko(genre);
			model.addAttribute("actionList", actionList);
			
			genre = "thriller";
			ArrayList<MovieVO> thrillerList = movieService.getList_ko("thriller");
			model.addAttribute("thrillerList", thrillerList);
			
			genre = "drama";
			ArrayList<MovieVO> dramaList = movieService.getList_ko("drama");
			model.addAttribute("dramaList", dramaList);
			
		} else if(nation.equals("out")){
			
			genre = "action";
			ArrayList<MovieVO> actionList = movieService.getList_out("action");
			model.addAttribute("actionList", actionList);
			
			genre = "thriller";
			ArrayList<MovieVO> thrillerList = movieService.getList_out("thriller");
			model.addAttribute("thrillerList", thrillerList);
			
			genre = "drama";
			ArrayList<MovieVO> dramaList = movieService.getList_out("drama");
			model.addAttribute("dramaList", dramaList);
			
		}
		
		
		return "movie/movieList";
		
	}
	
	@PostMapping("/addStarRate")
	public String addStarRate(@RequestParam ("movie_koficCd") String movie_koficCd,
							  @RequestParam ("rating") int rating,
							  RedirectAttributes RA,
							  Model model
							  ) {
		
		//별점 등록
		StarRateVO starRateVo = new StarRateVO();
		
		starRateVo.setMovie_koficCd(movie_koficCd);
		starRateVo.setUser_key(1);
		starRateVo.setSr_rate(rating);
		
		movieService.addStarRate(starRateVo);
		
		RA.addAttribute("movie_koficCd", movie_koficCd);
		
		return "redirect:/movie/movieDetail";
	}
	
	@PostMapping("/movieLike")
	public void movieLike() {
		
	}
	
}
