package com.project2.movieproject.admin;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.adminUploadVO;
import com.project2.movieproject.command.adminVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;

	@Value("${project.upload.path}") private String uploadPath;

	@Override
	public int movieRegist(MovieVO vo) {
		int result = adminMapper.movieRegist(vo);

		return result;
	}

	@Override
	public ArrayList<MovieVO> getMovieList(Criteria cri) {
		return adminMapper.getMovieList(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return adminMapper.getTotal(cri);
	}

	@Override
	public MovieVO getMovieDetail(int movie_koficCd) {
		return adminMapper.getMovieDetail(movie_koficCd);
	}

	//폴더생성 함수
	public String MakeFolder() { //날짜별 폴더생성 
		DateTimeFormatter datetime= DateTimeFormatter.ofPattern("yyMMdd"); 
		String date = LocalDateTime.now().format(datetime);

		//java.io인 것을import(업로드 경로 \\폴더명)
		File file = new File(uploadPath +"\\"+date); 
		if(file.exists() ==false) { //폴더가 존재하면 true 존재하지 않으면 false
			file.mkdir(); //폴더가 생성 
		} 
		return date; 
	}

	@Transactional(rollbackFor = Exception.class) 
	@Override
	public int noticeRegist(adminVO vo , List<MultipartFile> list) {
		int result = adminMapper.noticeRegist(vo);

		for(MultipartFile f : list) {
			String originName = f.getOriginalFilename();
			String filename = originName.substring(originName.lastIndexOf("\\")+1);
			String filepath = MakeFolder();
			String uuid = UUID.randomUUID().toString();
			String savename = uploadPath + "\\"+ filepath + "\\" +uuid + "_" +filename;

			try { 
				File saveFile = new File(savename);
				f.transferTo(new File(savename)); 

			} catch (Exception e) {
				e.printStackTrace(); 
				return 0; 
			}

			adminUploadVO adminUpVO = adminUploadVO.builder() 
					.filename(filename)
					.filepath(filepath) 
					.uuid(uuid) 
					.user_admin(vo.getAdmin_id()) 
					.build();
			adminMapper.registFile(adminUpVO);
		}
		return result;
	}

	@Override
	public adminVO getcontent(int admin_key) {

		return adminMapper.getcontent(admin_key);
	}

	@Override
	public int update(adminVO adminvo) {

		return adminMapper.update(adminvo);
	}

	@Override
	public int delete(int admin_user) {

		return adminMapper.delete(admin_user);
	}

	@Override
	public ArrayList<adminVO> List(Criteria cri) {

		return adminMapper.List(cri);
	}

	@Override //조회수 증가
	public int hit(adminVO adminvo) {

		return adminMapper.hit(adminvo);
	}

	@Override
	public int total(Criteria cri) {

		return adminMapper.total(cri);
	}

	@Override 
	public int registFile(adminUploadVO vo) { 
		return adminMapper.registFile(vo); 
	}

	@Override
	public adminUploadVO fileDetail(int user_id) {
		// TODO Auto-generated method stub
		return adminMapper.fileDetail(user_id);
	}
}
