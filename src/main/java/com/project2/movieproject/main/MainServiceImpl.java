package com.project2.movieproject.main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.adminVO;

@Service("mainService")
public class MainServiceImpl implements MainService {

	@Autowired
	private MainMapper mainMapper;

	@Override
	public ArrayList<MovieVO> getMainBanner() {
		return mainMapper.getMainBanner();
	}

	@Override
	public ArrayList<MovieVO> getMainRank() {
		return mainMapper.getMainRank();
	}

	@Override
	public ArrayList<MovieVO> getMainRankList() {
		return mainMapper.getMainRankList();
	}

	@Override
	public ArrayList<MovieVO> getMain_all_all() {
		
		return mainMapper.getMain_all_all();
	}
	
	@Override
	public ArrayList<adminVO> getMainNotices() {
		return mainMapper.getMainNotices();
	}
}
