package com.project2.movieproject.util;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class SPVO {
	private int pageCount;
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev, next;
	private int total;
	private SearchCriteria searchCriteria;
	public SPVO() {}
	public SPVO(int total, int pageCount, SearchCriteria searchCriteria) {
		this.total = total;
		this.searchCriteria = searchCriteria;
		this.pageCount = pageCount;
		this.endPage = (int) (Math.ceil(searchCriteria.getPageNum() * 1.0 / pageCount)) * pageCount;
		this.startPage = endPage - (pageCount - 1);
		realEnd = (int)(Math.ceil(total * 1.0 / searchCriteria.getAmount()));
		if(endPage > realEnd) {
			endPage = realEnd == 0 ? 1 : realEnd;
		}
		prev = startPage > 1;
		next = endPage < realEnd;
	}
}

