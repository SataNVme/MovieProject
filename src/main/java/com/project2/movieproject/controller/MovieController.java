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
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.StarRateVO;
import com.project2.movieproject.comment.CommentService;
import com.project2.movieproject.movieDetail.MovieService;

@Controller
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
							  Model model) {
		
		
		//movie select
		MovieVO movieVo = movieService.getDetail(movie_koficCd);
		
		//유튜브 주소
		String vUrl = movieVo.getMovie_vUrl();
		String url = "https://youtube.com/embed/" + vUrl.substring(32,43);
		
		//코멘트 주소
		String commentUrl = "/comment/commentList?movie_koficCd=" + movie_koficCd;
		model.addAttribute("commentUrl", commentUrl);
		
		//별점
		float starRate = movieService.getStarRate(movie_koficCd);
		model.addAttribute("starRate", starRate);
		
		//리뷰 등록
		model.addAttribute("url", url);
		model.addAttribute("movieVo", movieVo);
		
		return "movie/movieDetail";
		
	}
	
	@GetMapping("/movieList")
	public String movieList(@RequestParam("nation") String nation,
							Model model) {
		
		if(nation.equals("ko")) {
			MovieVO movieVO_action = movieService.getList_ko("액션");
			model.addAttribute("movieVO_action", movieVO_action);
			
			MovieVO movieVO_thriller = movieService.getList_ko("스릴러");
			model.addAttribute("movieVO_thriller", movieVO_thriller);
			
			MovieVO movieVO_romance = movieService.getList_ko("로맨스");
			model.addAttribute("movieVO_romance", movieVO_romance);
			
			return "movie/movieList";
			
		} else if(nation.equals("out")){
			MovieVO movieVO_action = movieService.getList_out("액션");
			model.addAttribute("movieVO_action", movieVO_action);
			
			MovieVO movieVO_thriller = movieService.getList_out("스릴러");
			model.addAttribute("movieVO_thriller", movieVO_thriller);
			
			MovieVO movieVO_romance = movieService.getList_out("로맨스");
			model.addAttribute("movieVO_romance", movieVO_romance);
			
			return "movie/movieList";
			
		} else {
			
			return "movie/movieList?nation=ko";
			
		}
		
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
	
}
