package com.project2.movieproject.search;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.SearchVO;
import com.project2.movieproject.util.SearchCriteria;

@Service
public interface SearchService {

	public List<MovieVO> getSearchList(SearchCriteria searchCriteria);
	public MovieVO get(String movie_koficCd);
	public int getTotal();

}
