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
	public MovieVO getSearchListDetail(String movie_koficCd) {
		return searchMapper.getSearchListDetail(movie_koficCd);
	}

	@Override
	public List<MovieVO> getSearchList() {
		return searchMapper.getSearchList();
	}

	@Override
	public int getTotalCount() {
		return searchMapper.getTotalCount();
	}

	

	
	

	
	
}
