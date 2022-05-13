package com.project2.movieproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.admin.AdminService;
import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.MovieVO;
import com.project2.movieproject.command.PageVO;
import com.project2.movieproject.command.UserVO;
import com.project2.movieproject.command.adminVO;
import com.project2.movieproject.command.qaVO;
import com.project2.movieproject.user.UserService;

@Controller
@SessionAttributes("vo")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;
	//게시판
	@GetMapping("/adminMain1")
	public String adminMain1(Model model,@ModelAttribute("vo")UserVO uservo1) {
		
		ArrayList<UserVO> uservo = userService.userlist1();
		model.addAttribute("UserVO", uservo);
		model.addAttribute("vo1", uservo1);
		return "admin/adminMain1";
	}

	//문의사항
	@GetMapping("/qna")
	public void qna(Model model,@ModelAttribute("vo")UserVO uservo) {

		ArrayList<qaVO> qalist = userService.qa_list();
		model.addAttribute("vo1",uservo);
		model.addAttribute("qalist", qalist);
	}

	//화면폼
	@GetMapping("/notice_regist2")
	public String notice_regist2() {

		return "admin/notice_regist2";
	}

	@PostMapping("/noticeRegist")//등록(나중에 첨부파일도)

	public String noticeRegist(adminVO vo, RedirectAttributes RA,@RequestParam("file") MultipartFile list,Model model,@ModelAttribute("vo")UserVO uservo1 )
		 {
				/*
				 * for(MultipartFile f:list) { System.out.println(f.isEmpty());
				 * System.out.println(f.getContentType()); } System.out.println(vo.toString());
				 */
		
		
		 System.out.println(vo.toString());
		 
		model.addAttribute("vo1","uservo1");
		int result = adminService.noticeRegist(vo,list);

		if(result == 1) {
			RA.addFlashAttribute("msg", vo.getAdmin_id()+"등록이 성공했습니다.");
		}else {
			RA.addFlashAttribute("msg", "등록에 실패했습니다.");
		}

	

	return"redirect:/admin/notices";
}
	


	@GetMapping("/notices")//목록
	public String notices(Model model,Criteria cri, @ModelAttribute("vo")UserVO uservo,RedirectAttributes RA) {

		ArrayList<adminVO> list=adminService.List(cri);
		int total=adminService.total(cri);


		PageVO pageVO = new PageVO(cri, total);

		model.addAttribute("vo1",uservo);
		
		model.addAttribute("list", list); 
		model.addAttribute("pageVO", pageVO);
		System.out.println(uservo.toString());
		
		if(uservo.getUser_id() == null || uservo.getUser_id() == "") {
			RA.addFlashAttribute("msg", "로그인을 하셔야 공지사항을 보실수 있습니다.");	
			return "redirect:/main";
		
			
		}
		
		return "admin/notices";
	}

	@GetMapping("/notice_regist")
	public String notice_regist(@RequestParam("admin_key") int admin_key, 
			Model model,@ModelAttribute("vo")UserVO uservo1) {

		adminVO adminvo = adminService.getcontent(admin_key);
		model.addAttribute("adminvo", adminvo);

		int hit =adminService.hit(adminvo);
		model.addAttribute("hit",hit);

		
		model.addAttribute("vo1" , uservo1);
		


		return "admin/notice_regist";
	}


	@PostMapping("/noticeUpdate")//게시글 수정하기

	public String noticeUpdate(@Valid adminVO adminvo, 
			Model model,RedirectAttributes RA,
			Errors erros) {
		if(erros.hasErrors()) { //유효성 검사 실패시 true

			List<FieldError> list = erros.getFieldErrors(); //유효성검사 실패 목록확인
			for(FieldError err : list) {
				//System.out.println(err.getField()); //유효성 검사 실패 멤버변수
				//System.out.println(err.getDefaultMessage()); //유효성 검사 실패 메시지

				if(err.isBindingFailure()) { //자바측 에러인 경우
					model.addAttribute("valid_" + err.getField(), "형식을 확인하세요"); //직접 에러메시지 생성
				} else { 
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage()); //유효성 검사 실패 메시지
				}


			
			}
	
			
		
			
		
			
		
			//화면에서는 prodVO이름으로 상세페이지에서 사용되고 있기 때문에, 같은 이름으로 보내서 처리합니다.
			model.addAttribute("admin", adminvo); 
			
			return "product/productDetail"; //유효성; 검사에 실패하면 다시 화면으로

		}

		int result = adminService.update(adminvo);

		if(result == 1) {
			RA.addFlashAttribute("msg", "수정이 성공했습니다.");
		}else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다.");
		}

		return "redirect:/admin/notices";
	}

	@PostMapping("/noticeDelete")
	public String noticeDelete(@RequestParam("admin_key") int admin_key,
								RedirectAttributes RA) {

		int result = adminService.delete(admin_key);
		
		if(result == 1) {
			
			RA.addFlashAttribute("msg", "삭제에 성공했습니다.");

		}else {
			RA.addFlashAttribute("msg", "삭제에 실패했습니다.");
		}

		return "redirect:/admin/notices";
	}

	//api에서 영화를 검색해서 DB에 등록하는 페이지
	@GetMapping("/adminMovieReg")
	public String adminMovieReg() {
		return "admin/adminMovieReg";
	}

	//api에서 영화를 검색해서 DB에 등록하는 폼
	@PostMapping("/movieRegForm")
	public String movieRegForm(MovieVO vo,
			RedirectAttributes RA) {
		int result = adminService.movieRegist(vo);

		if(result > 0) { //성공
			RA.addFlashAttribute("msg", "영화가 정상 등록되었습니다" );
		} else { //실패
			RA.addFlashAttribute("msg", "영화가 등록되지 않았습니다. 관리에게 문의하세요.");
		}

		return "redirect:/admin/adminMovieReg";
	}

	// DB에 있는 영화 목록페이지
	@GetMapping("/adminMovieList")
	public String adminMovieList(Model model, Criteria cri) {

		ArrayList<MovieVO> list = adminService.getMovieList(cri);
		int total = adminService.getTotal(cri);
		
		PageVO pageVO = new PageVO(cri, total);

		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);

		return "admin/adminMovieList";
	}

	// DB에 있는 영화 목록페이지에서 상세화면
	@GetMapping("/adminMovieDetail")
	public String adminMovieDetail(@RequestParam("movie_koficCd") int movie_koficCd,
			Model model) {

		MovieVO vo = adminService.getMovieDetail(movie_koficCd);
		model.addAttribute("vo", vo);

		return "admin/adminMovieDetail";
	}
	


	@GetMapping("/user_Info")
	public String userMypage(@ModelAttribute("vo") UserVO vo, Model model) {
		String db_id = vo.getUser_id();
		System.out.println(vo.getUser_id());
		

		ArrayList<UserVO> userdata = userService.userdata(db_id);
		System.out.println(userdata);
		
		model.addAttribute("userdata", userdata);
		return "admin/user_info";
	}
	@GetMapping("/replyPage")
	public String replyPage(@RequestParam("qa_key") Integer qa_key, Model model) {
		ArrayList<qaVO> qa_data = userService.qa_read(qa_key);
		model.addAttribute("qa_data", qa_data);

		return "admin/replyPage";

	}
	
	@PostMapping("/qa_update")
	public String qa_update(qaVO vo, Model model, RedirectAttributes RA) {
		int qa_update = userService.qa_update(vo);
		System.out.println(vo.getQa_key());
		System.out.println(vo.getQa_comment());
		if(qa_update == 1 ) {
			RA.addFlashAttribute("msg", "답변이 등록되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "실패했습니다. 관리자에게 문의하세요");
		}
		return "redirect:/admin/qna";
	}
}
