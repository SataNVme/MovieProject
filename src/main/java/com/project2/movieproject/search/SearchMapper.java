package com.project2.movieproject.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.SearchVO;
import com.project2.movieproject.util.SearchCriteria;

@Mapper
public interface SearchMapper {
	// 단일값, vo, map, annotation param
	// 검색 목록(페이징 적용)
	public ArrayList<SearchVO> getSearchList(Criteria cri);
	public int getTotal(Criteria cri);
	public SearchVO getSearchDetail(int movie_koficCd);
}
