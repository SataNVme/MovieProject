package com.project2.movieproject.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.SearchVO;
import com.project2.movieproject.util.SearchCriteria;

@Service
public interface SearchService {

	public ArrayList<SearchVO> getSearchList(Criteria cri);
	public int getTotal(Criteria cri);
	public SearchVO getSearchDetail(int movie_koficCd);

}
