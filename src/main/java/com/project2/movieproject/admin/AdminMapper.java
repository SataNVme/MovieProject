package com.project2.movieproject.admin;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.MovieVO;
<<<<<<< HEAD
import com.project2.movieproject.command.adminUploadVO;
=======

>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
import com.project2.movieproject.command.adminVO;

@Mapper
public interface AdminMapper {
	public int movieRegist(MovieVO vo);
<<<<<<< HEAD
	public int movieSearch(MovieVO vo);
	public ArrayList<MovieVO> getMovieList();
=======
	public ArrayList<MovieVO> getMovieList(Criteria cri);
	public int getTotal(Criteria cri);
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	public MovieVO getMovieDetail(int movie_koficCd);
	
	public int noticeRegist(adminVO vo);//등록
	public ArrayList<adminVO> List(Criteria cri);//목록
	public int total(Criteria cri);//전체게시글수
	public adminVO getcontent(int admin_key);//상세
	public int hit(adminVO adminvo);//조회수
	public int update(adminVO adminvo);//수정
	public int delete(int admin_id);//삭제
<<<<<<< HEAD
	public adminUploadVO fileDetail(int user_id);//다운로드에 필요한
	public int registFile(adminUploadVO vo); //파일등록
=======
	
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
}
