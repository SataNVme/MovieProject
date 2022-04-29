package com.project2.movieproject.comment;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.CommentVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public int regist(CommentVO vo) {
		
		return commentMapper.regist(vo);
		
	}

	@Override
	public ArrayList<CommentVO> getList() {
		return commentMapper.getList();
	}
	
	

}
