package com.project2.movieproject.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.UserVO;
import com.project2.movieproject.command.qaVO;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int regist(UserVO vo) {
		
		return userMapper.regist(vo);
	}

	@Override
	public int idCheck(String id) {
		return userMapper.idCheck(id);
	}

	@Override
	public ArrayList<UserVO> userdata(String db_id) {
		return userMapper.userdata(db_id);
	}

	@Override
	public int user_update(UserVO vo) {
		return userMapper.user_update(vo);
	}

	@Override
	public int user_delete(UserVO vo) {
		return userMapper.user_delete(vo);
	}

	@Override
	public ArrayList<UserVO> userlist() {
		return userMapper.userlist();
	}

	@Override
	public int qa_regist(qaVO vo) {
		return userMapper.qa_regist(vo);
	}

	@Override
	public ArrayList<qaVO> myqa_read(String user_id) {
		return userMapper.myqa_read(user_id);
	}

	@Override
	public ArrayList<qaVO> qa_read(String qa_title) {
		return userMapper.qa_read(qa_title);
	}
	
}
