package com.project2.movieproject;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.project2.movieproject.command.CommentVO;
import com.project2.movieproject.comment.CommentMapper;

@SpringBootTest
class MovieProjectApplicationTests {
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Test
	public void test02() {
		for (int i = 1; i <= 100; i++) {
			
			CommentVO vo = CommentVO.builder().comment_key(i)
											  .user_id("1")
											  .comment_com("리뷰입니다" + i)
											  .comment_rank(0)
											  .comment_date(LocalDateTime.now())
											  .comment_class(0)
											  .comment_group(0)
											  .comment_sort(0)
											  .comment_like(0)
											  .comment_unlike(0)
											  .comment_mn("19990084")
											  .build();
			
			commentMapper.regist(vo);
			
		}
	}

}
