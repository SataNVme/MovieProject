package com.project2.movieproject.util;

import lombok.Data;

@Data
public class SearchCriteria {

	public int pageNum;
	public int amount;
	
	private String searchType; // 제목
	private String searchName; // 내용
	
	public int amount() {
		return (this.pageNum - 1) * amount;
	}
	public SearchCriteria() {
		this(1, 10);
	}
	public SearchCriteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
