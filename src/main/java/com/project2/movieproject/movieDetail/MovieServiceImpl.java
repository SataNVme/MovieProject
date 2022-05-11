package com.project2.movieproject.movieDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public MovieVO getList_ko(String genre) {
		return movieMapper.getList_ko(genre);
	}
	
	@Override
	public MovieVO getList_out(String genre) {
		return movieMapper.getList_out(genre);
	
	}
	
	@Override
	public void addStarRate(StarRateVO starRateVo) {
		movieMapper.addStarRate(starRateVo);
	}
	
	@Override
	public Float getStarRate(String movie_koficCd) {
		return movieMapper.getStarRate(movie_koficCd);
	}

}
