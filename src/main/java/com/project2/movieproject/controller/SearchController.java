package com.project2.movieproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project2.movieproject.search.SearchService;
import com.project2.movieproject.util.SPVO;
import com.project2.movieproject.util.SearchCriteria;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/getSearchList")
	public void searchListGet(Model model, SearchCriteria searchCriteria) {
		model.addAttribute("getSearchList", searchService.getSearchList(searchCriteria));
		int total = searchService.getTotal(searchCriteria);
		SPVO spVO = new SPVO(searchCriteria, total);
		model.addAttribute("spvo", spVO);
	}
	
}
