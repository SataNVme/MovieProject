package com.project2.movieproject.main;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.adminVO;

@Mapper
public interface MainMapper {

	public ArrayList<MovieVO> getMainBanner();
	public ArrayList<MovieVO> getMainRank();
	public ArrayList<MovieVO> getMainRankList();
	
	public ArrayList<MovieVO> getMain_all_all();
	
	public ArrayList<adminVO> getMainNotices();
}