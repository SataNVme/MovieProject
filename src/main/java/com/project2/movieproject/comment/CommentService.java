package com.project2.movieproject.comment;

import java.util.ArrayList;

import com.project2.movieproject.command.CommentVO;

public interface CommentService {
	
	public int regist(CommentVO vo);
	public ArrayList<CommentVO> getList();

}
