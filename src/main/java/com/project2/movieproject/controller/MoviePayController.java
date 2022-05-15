package com.project2.movieproject.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project2.movieproject.command.MoviePayVO;
import com.project2.movieproject.moviepayment.MovieOrder;
import com.project2.movieproject.moviepayment.MovieOrderForm;
import com.project2.movieproject.moviepayment.MovieOrderRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MoviePayController {

	private final MovieOrderRepository movieOrderRepository;
	
	@GetMapping("/movie/movieDetail")
    public String moviepayment() {
        return "/movie/movieDetail";
    }
	/**
     * 결제 정보 입력
     */
    @PostMapping("/movie/moviePay")
    public String moviePay(MovieOrderForm movieOrderForm, Model model) {
        MovieOrder movieOrder = MovieOrder.builder()
                						  .user_name(movieOrderForm.getUser_name())
                						  .movie_sellPrice(movieOrderForm.getMovie_sellPrice())
                						  .movie_nm(movieOrderForm.getMovie_nm())
                						  .createdDate(LocalDateTime.now())
                						  .build();
        MovieOrder saveOrder = movieOrderRepository.save(movieOrder);

        model.addAttribute("saveOrder", saveOrder);
        return "movie/moviePay";
    }

    @PostMapping("/movie/movieRent")
    public String movieRent(MovieOrderForm movieOrderForm, Model model) {
        MovieOrder movieOrder = MovieOrder.builder()
                						  .user_name(movieOrderForm.getUser_name())
                						  .movie_rentPrice(movieOrderForm.getMovie_rentprice())
                						  .movie_nm(movieOrderForm.getMovie_nm())
                						  .createdDate(LocalDateTime.now())
                						  .build();
        MovieOrder saveOrder = movieOrderRepository.save(movieOrder);

        model.addAttribute("saveOrder", saveOrder);
        return "movie/movieRent";
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

