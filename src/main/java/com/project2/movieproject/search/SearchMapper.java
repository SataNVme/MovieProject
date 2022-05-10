package com.project2.movieproject.search;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.MovieVO;
<<<<<<< HEAD
import com.project2.movieproject.util.SearchCriteria;

@Mapper
public interface SearchMapper {
	// 단일값, vo, map, annotation param
	public List<MovieVO> getSearchList(SearchCriteria searchCriteria);
	public MovieVO get(String movie_koficCd);
	public int getTotal();

=======
//import com.project2.movieproject.util.SearchCriteria;

@Mapper
public interface SearchMapper {
	
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
}
