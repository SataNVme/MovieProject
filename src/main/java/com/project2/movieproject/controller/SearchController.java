package com.project2.movieproject.controller;


import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.PageVO;
import com.project2.movieproject.command.SearchVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project2.movieproject.search.SearchService;
import com.project2.movieproject.util.SPVO;
import com.project2.movieproject.util.SearchCriteria;


@Controller
@SessionAttributes("vo")
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	// DB에 있는 영화 목록페이지
	@GetMapping("/getSearchList")
		public String getSearchList(Model model, Criteria cri) {

			ArrayList<SearchVO> list = searchService.getSearchList(cri);
			int total = searchService.getTotal(cri);
			
			PageVO pageVO = new PageVO(cri, total);

			model.addAttribute("list", list);
			model.addAttribute("pageVO", pageVO);

			return "search/getSearchList";
		}
	
}
