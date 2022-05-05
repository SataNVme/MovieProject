package com.project2.movieproject.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class qaVO {
	
	private Integer qa_key;
	private String user_id;
	private String qa_title;
	private String qa_content;
	private LocalDateTime qa_date;
	private String qa_comment;
}
