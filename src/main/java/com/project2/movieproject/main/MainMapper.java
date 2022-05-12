package com.project2.movieproject.main;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.MovieVO;

@Mapper
public interface MainMapper {

	public ArrayList<MovieVO> getMainBanner();
	public ArrayList<MovieVO> getMainRank();
	public ArrayList<MovieVO> getMainRankList();
}
