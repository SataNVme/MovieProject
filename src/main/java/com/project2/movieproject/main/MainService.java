package com.project2.movieproject.main;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.adminVO;

@Service
public interface MainService {
	
	public ArrayList<MovieVO> getMainBanner();
	public ArrayList<MovieVO> getMainRank();
	public ArrayList<MovieVO> getMainRankList();
	
	public ArrayList<MovieVO> getMain_all_all();
	
	public ArrayList<adminVO> getMainNotices();
}