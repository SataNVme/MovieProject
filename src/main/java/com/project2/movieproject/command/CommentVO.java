package com.project2.movieproject.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentVO {
	
	private Integer comment_key;
	private String user_id;
	private String comment_com;
	private Integer comment_rank;
	private Date comment_date;
	private Integer comment_class;
	private Integer comment_group;
	private Integer comment_sort;
	private Integer comment_like;
	private Integer comment_unlike;
	
	

}
