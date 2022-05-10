package com.project2.movieproject.search;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.MovieVO;
<<<<<<< HEAD
import com.project2.movieproject.util.SearchCriteria;
=======
//import com.project2.movieproject.util.SearchCriteria;
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	
<<<<<<< HEAD
	@Autowired
	private SearchMapper searchMapper;

	@Override
	public List<MovieVO> getSearchList(SearchCriteria searchCriteria) {
		return searchMapper.getSearchList(searchCriteria);
	}

	@Override
	public MovieVO get(String movie_koficCd) {
		return searchMapper.get(movie_koficCd);
	}

	@Override
	public int getTotal() {
		return searchMapper.getTotal();
	}
=======
	

	
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66

	
	

	
	
}
