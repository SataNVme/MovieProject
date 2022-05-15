package com.project2.movieproject.movieDetail;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieLikeVO;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.StarRateVO;

@Service("movieService")
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public MovieVO getDetail(String movie_koficCd) {
		return movieMapper.getDetail(movie_koficCd);
	}
	
	
	@Override
	public ArrayList<MovieVO> getList_ko(String movie_gr) {
		return movieMapper.getList_ko(movie_gr);
	}
	
	@Override
	public ArrayList<MovieVO> getList_out(String movie_gr) {
		System.out.println(movie_gr);
		return movieMapper.getList_out(movie_gr);
	
	}
	
	@Override
	public void addStarRate(StarRateVO starRateVo) {
		movieMapper.addStarRate(starRateVo);
	}
	
	@Override
	public Float getStarRate(String movie_koficCd) {
		return movieMapper.getStarRate(movie_koficCd);
	}
	
	@Override
	public MovieLikeVO getMovieLike(MovieLikeVO movieLikeVO) {
		return movieMapper.getMovieLike(movieLikeVO);
	}
	
	@Override
	public void addMovieLike(MovieLikeVO movieLikeVO) {
		movieMapper.addMovieLike(movieLikeVO);
	}
	
	@Override
	public void removeMovieLike(MovieLikeVO movieLikeVO) {
		movieMapper.removeMovieLike(movieLikeVO);
	}

}