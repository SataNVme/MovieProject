package com.project2.movieproject.command;

import java.sql.Date;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66

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
<<<<<<< HEAD
	private LocalDateTime comment_date;
=======
	private Date comment_date;
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	private Integer comment_class;
	private Integer comment_group;
	private Integer comment_sort;
	private Integer comment_like;
	private Integer comment_unlike;
<<<<<<< HEAD
	private String comment_mn;
	
=======
	
	

>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
}
