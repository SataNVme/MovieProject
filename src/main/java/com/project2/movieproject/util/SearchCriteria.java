package com.project2.movieproject.util;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import lombok.Data;

@Component
@Data
public class SearchCriteria {
	// https://hong-coding.tistory.com/124?category=1234249
	private int pageNum;
	private int amount;
	private String type;
	private String keyword;
	public SearchCriteria() {this(1, 10);}
	public SearchCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("amount", amount);
		return builder.toUriString();
	}
	public String[] getTypeArr() {
		return type == null ? new String[]{} : type.split("");
	}
}
