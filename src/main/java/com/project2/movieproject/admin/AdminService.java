package com.project2.movieproject.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.MovieVO;
<<<<<<< HEAD
import com.project2.movieproject.command.adminUploadVO;
=======

>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
import com.project2.movieproject.command.adminVO;

public interface AdminService {
	public int movieRegist(MovieVO vo);
<<<<<<< HEAD
	public int movieSearch(MovieVO vo);
	public ArrayList<MovieVO> getMovieList();
	public MovieVO getMovieDetail(int movie_koficCd);
	
	public int noticeRegist(adminVO vo,List<MultipartFile> list );//등록
=======
	public ArrayList<MovieVO> getMovieList(Criteria cri);
	public int getTotal(Criteria cri);
	public MovieVO getMovieDetail(int movie_koficCd);
	
	public int noticeRegist(adminVO vo,MultipartFile list );//등록
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	public ArrayList<adminVO> List(Criteria cri);//목록
	public int total(Criteria cri);//전체게시글수
	public adminVO getcontent(int admin_key);//상세
	public int hit(adminVO adminvo);//조회수
<<<<<<< HEAD
	public int update(adminVO adminvo);//수정
	public int delete(int admin_id);//삭제
	public adminUploadVO fileDetail(int user_id);//이미지처리
	public int registFile(adminUploadVO vo);//파일등록
=======
	
	public int delete(int admin_id);//삭제
	public int update(adminVO adminvo);
	
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
}
