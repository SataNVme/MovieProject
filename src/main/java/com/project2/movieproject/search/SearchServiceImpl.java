package com.project2.movieproject.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.SearchVO;
import com.project2.movieproject.util.SearchCriteria;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchMapper searchMapper;

	@Override
	public ArrayList<SearchVO> getSearchList(Criteria cri) {
		return searchMapper.getSearchList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return searchMapper.getTotal(cri);
	}

	@Override
	public SearchVO getSearchDetail(int movie_koficCd) {
		return searchMapper.getSearchDetail(movie_koficCd);
	}

	


}
