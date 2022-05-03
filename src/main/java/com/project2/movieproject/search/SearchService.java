package com.project2.movieproject.search;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.SearchVO;
import com.project2.movieproject.util.SearchCriteria;

@Service
public interface SearchService {

	public MovieVO getSearchListDetail(String movie_koficCd);
	public List<MovieVO> getSearchList();
	public int getTotalCount();
	
}
