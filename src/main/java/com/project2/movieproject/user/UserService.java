package com.project2.movieproject.user;

import java.util.ArrayList;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.UserVO;

public interface UserService {
	
	public int regist(UserVO vo); //등록
	public int idCheck(String id);
	public ArrayList<UserVO> userdata(String db_id);
	public int user_update(UserVO vo);
	public ArrayList<UserVO> userlist(Criteria cri);
	public int total(Criteria cri);//전체회원글수
}
