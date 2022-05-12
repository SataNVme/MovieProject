package com.project2.movieproject.search;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.util.SearchCriteria;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchMapper searchMapper;

	@Override
	public List<MovieVO> getSearchList(SearchCriteria searchCriteria) {
		return searchMapper.getSearchList(searchCriteria);
	}

	@Override
	public int getTotal(SearchCriteria searchCriteria) {
		return searchMapper.getTotal(searchCriteria);
	}


}
