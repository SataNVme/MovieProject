package com.project2.movieproject.comment;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.CommentVO;

@Mapper
public interface CommentMapper {
	
	public int regist(CommentVO vo);
	
	public ArrayList<CommentVO> getList();	
	
	public String getTime();

}
