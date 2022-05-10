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
<<<<<<< HEAD
/*  qa_key      INT   PRIMARY KEY AUTO_INCREMENT,
   user_key   INT   NOT NULL, ##FK
   qa_title   VARCHAR(20)   NOT NULL,
   qa_content   VARCHAR(5000)   NOT NULL,
   qa_date      TIMESTAMP DEFAULT NOW()*/
	
	private Integer qa_key;
	private Integer user_key;
	private String qa_title;
	private String qa_content;
	private LocalDateTime qa_data;
=======
	
	private Integer qa_key;
	private String user_id;
	private String qa_title;
	private String qa_content;
	private LocalDateTime qa_date;
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	private String qa_comment;
}
