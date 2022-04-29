package com.project2.movieproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project2.movieproject.search.SearchService;
import com.project2.movieproject.util.SPVO;
import com.project2.movieproject.util.SearchCriteria;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
	
	@Autowired
	@Qualifier("searchService")
	private SearchService searchService;
	
	@GetMapping("getSearchList")
	public String list(SearchCriteria searchCriteria, Model model) {
		model.addAttribute("list", searchService.getSearchList(searchCriteria));
		model.addAttribute("pageMaker", new SPVO(searchService.getTotal(), 10, searchCriteria));
		return "search/getSearchList";
		
	}
}
