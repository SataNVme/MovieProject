package com.project2.movieproject.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.command.CommentVO;
import com.project2.movieproject.command.MovieLikeVO;
import com.project2.movieproject.command.MoviePayVO;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.StarRateVO;
import com.project2.movieproject.command.UserVO;
import com.project2.movieproject.comment.CommentService;
import com.project2.movieproject.movieDetail.MovieService;
import com.project2.movieproject.movieDetail.MovieOrder;
import com.project2.movieproject.movieDetail.MovieOrderForm;
import com.project2.movieproject.movieDetail.MovieOrderRepository;

@Controller
@SessionAttributes("vo")
@RequestMapping("/movie")
public class MovieController {
	
	private MovieOrderRepository movieOrderRepository;
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
		
		//좋아요 여부 체크
		MovieLikeVO movieLikeVO = new MovieLikeVO();
		movieLikeVO.setMovie_koficCd(movie_koficCd);
		movieLikeVO.setUser_id(sessionvo.getUser_id());
		
		//좋아요 추가/제거
		int movieLike;
		if(movieService.getMovieLike(movieLikeVO) == null) {
			movieLike = 0;
		} else {
			movieLike = 1;
		}
		model.addAttribute("movieLike", movieLike);
		
		return "movie/movieDetail";
		
	}
	
	@GetMapping("/movieList")
	public String movieList(@RequestParam("nation") String nation,
							Model model) {
		
		String genre;
		if(nation.equals("ko")) {
			genre = "action";
			ArrayList<MovieVO> actionList = movieService.getList_ko("action");
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
	
	@PostMapping("/addMovieLike")
	public String addMovieLike(@RequestParam ("movie_koficCd") String movie_koficCd,
							@ModelAttribute("vo") UserVO sessionvo,
							RedirectAttributes RA) {
		
		MovieLikeVO movieLikeVO = new MovieLikeVO();
		movieLikeVO.setMovie_koficCd(movie_koficCd);
		
		String movieLikeMsg;
		if(sessionvo.getUser_id() == null) {
			movieLikeMsg = "로그인이 필요합니다";
			RA.addFlashAttribute("movieLikeMsg", movieLikeMsg);
			return "redirect:/user/userLogin";
		} else {
			movieLikeVO.setUser_id(sessionvo.getUser_id());
			movieService.addMovieLike(movieLikeVO);
			
			movieLikeMsg = "관심 영화를 등록했습니다";
			RA.addFlashAttribute("movieLikeMsg", movieLikeMsg);
			
			RA.addAttribute("movie_koficCd", movie_koficCd);
			
			return "redirect:/movie/movieDetail";
		}
	}
	
	@PostMapping("/removeMovieLike")
	public String removeMovieLike(@RequestParam ("movie_koficCd") String movie_koficCd,
								@ModelAttribute("vo") UserVO sessionvo,
								RedirectAttributes RA) {
		
		MovieLikeVO movieLikeVO = new MovieLikeVO();
		movieLikeVO.setMovie_koficCd(movie_koficCd);
		movieLikeVO.setUser_id(sessionvo.getUser_id());
		movieService.removeMovieLike(movieLikeVO);
		
		RA.addAttribute("movie_koficCd", movie_koficCd);
			
		return "redirect:/movie/movieDetail";
	}
	
	/**
     * 결제 정보 입력
     */
    @PostMapping("/movie/moviePay")
    public String moviePay(MovieOrderForm movieOrderForm, Model model, @RequestParam ("movie_koficCd") String movie_koficCd,
			@ModelAttribute("vo") UserVO sessionvo, RedirectAttributes RA) {
        			MovieOrder movieOrder = MovieOrder.builder()
                						  			  .user_name(movieOrderForm.getUser_name())
                						  			  .movie_sellPrice(movieOrderForm.getMovie_sellPrice())
                						  			  .movie_nm(movieOrderForm.getMovie_nm())
                						  			  .createdDate(LocalDateTime.now())
                						  			  .build();
        			MovieOrder saveOrder = movieOrderRepository.save(movieOrder);
        			model.addAttribute("saveOrder", saveOrder);
        			return "movie/moviePaySuccess";
    }

    @PostMapping("/movie/movieRent")
    public String movieRent(MovieOrderForm movieOrderForm, Model model, @RequestParam ("movie_koficCd") String movie_koficCd,
			@ModelAttribute("vo") UserVO sessionvo, RedirectAttributes RA) {
		MovieOrder movieOrder = MovieOrder.builder()
    						  			  .user_name(movieOrderForm.getUser_name())
    						  			  .movie_rentPrice(movieOrderForm.getMovie_rentPrice())
    						  			  .movie_nm(movieOrderForm.getMovie_nm())
    						  			  .createdDate(LocalDateTime.now())
    						  			  .build();
		MovieOrder saveOrder = movieOrderRepository.save(movieOrder);
		model.addAttribute("saveOrder", saveOrder);
		return "movie/moviePaySuccess";
    }

    /**
     * 결제가 실패하면 취소됨 
     */
    @PostMapping("/movie/moviePayFail")
    public String deletePay(@RequestParam("id") Long id) {
        movieOrderRepository.deleteById(id);
        return "movie/moviePayFail";
    }

    /**
     * 결제 성공시
     */
    @PostMapping("/movie/moviePaySuccess")
    public String completePay(@RequestBody MoviePayVO vo) {
        return "movie/moviePaySuccess";
    }

//    public String getToken(HttpServletRequest request){
//
//        String token;
//        return token;
//    }
	
}