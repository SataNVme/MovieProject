package com.project2.movieproject.movieDetail;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.StarRateVO;

public interface MovieService {

	public MovieVO getDetail(String movie_koficCd);
	public MovieVO getList_ko(String genre);
	public MovieVO getList_out(String genre);
	public void addStarRate(StarRateVO starRateVo);
	public Float getStarRate(String movie_koficCd);
}
