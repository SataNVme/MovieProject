package com.project2.movieproject.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class SPVO {

	private int start;
	private int end;
	private boolean prev;
	private boolean next;
	
	private int amount;
	private int pageNum;
	private int total;
	private int realEnd;
	
	private SearchCriteria searchCriteria;
	
	private List<Integer> pageList;
	
	public SPVO(SearchCriteria searchCriteria, int total) {
		this.pageNum = searchCriteria.getPageNum();
		this.amount = searchCriteria.getAmount();
		this.total = total;
		this.searchCriteria = searchCriteria;
		
		this.end = (int) Math.ceil(this.pageNum / 5.0) * 5;
		this.start = this.end - 5 + 1;
		this.realEnd = (int) Math.ceil(this.total / (double) this.amount);
		if(this.end > this.realEnd) {
			this.end = this.realEnd;
		}
		this.prev = this.start > 1;
		this.next = this.realEnd > this.end;
		this.pageList = IntStream.rangeClosed(this.start, this.end)
				.boxed()
				.collect(Collectors.toList());
	}

}
