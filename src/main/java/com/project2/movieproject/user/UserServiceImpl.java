package com.project2.movieproject.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.movieproject.command.UserVO;

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

	
}
