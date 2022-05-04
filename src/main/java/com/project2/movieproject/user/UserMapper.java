package com.project2.movieproject.user;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.UserVO;

@Mapper
public interface UserMapper {

	public int regist(UserVO vo); //등록
	public int idCheck(String id);
	public ArrayList<UserVO> userdata(String db_id);
	public int user_update(UserVO vo);
	public ArrayList<UserVO> userlist(Criteria cri);
	public int total(Criteria cri);//전체회원글수
}
