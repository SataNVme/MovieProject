package com.project2.movieproject.movieDetail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.OrderDetailVO;
import com.project2.movieproject.command.OrderListVO;
import com.project2.movieproject.command.OrderVO;
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
	public ArrayList<MovieVO> getList_ko(String genre) {
		return movieMapper.getList_ko(genre);
	}
	
	@Override
	public ArrayList<MovieVO> getList_out(String genre) {
		System.out.println(genre);
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


	@Override
	public void orderInfo(OrderVO order) {
		movieMapper.orderInfo(order);
		
	}


	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) {
		movieMapper.orderInfo_Details(orderDetail);
	}


	@Override
	public List<OrderVO> orderList(OrderVO order) {
		return movieMapper.orderList(order);
	}


	@Override
	public List<OrderListVO> orderView(OrderVO order) {
		return movieMapper.orderView(order);
	}

}
