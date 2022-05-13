package com.project2.movieproject.movieDetail;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.OrderDetailVO;
import com.project2.movieproject.command.OrderListVO;
import com.project2.movieproject.command.OrderVO;
import com.project2.movieproject.command.StarRateVO;

@Mapper
public interface MovieMapper {
	
	public MovieVO getDetail(String movie_koficCd);
	
	public ArrayList<MovieVO> getList_ko(String genre);
	
	public ArrayList<MovieVO> getList_out(String genre);
	
	public void addStarRate(StarRateVO starRateVo);
	
	public Float getStarRate(String movie_koficCd);
	
	public void orderInfo(OrderVO order);
	
	public void orderInfo_Details(OrderDetailVO orderDetail);
	
	public List<OrderVO> orderList(OrderVO order);
	
	public List<OrderListVO> orderView(OrderVO order);

}
