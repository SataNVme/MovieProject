package com.project2.movieproject.movieDetail;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.StarRateVO;

@Mapper
public interface MovieMapper {
	
	public MovieVO getDetail(String movie_koficCd);
	
	public MovieVO getList_ko(String genre);
	
	public MovieVO getList_out(String genre);
	
	public void addStarRate(StarRateVO starRateVo);
	
	public Float getStarRate(String movie_koficCd);

}
