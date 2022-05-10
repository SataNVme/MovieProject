package com.project2.movieproject.controller;

import java.util.ArrayList;

<<<<<<< HEAD
=======
import org.hibernate.internal.build.AllowSysOut;
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
<<<<<<< HEAD
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.command.UserVO;
=======
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.PageVO;
import com.project2.movieproject.command.UserVO;
import com.project2.movieproject.command.qaVO;
import com.project2.movieproject.user.EmailServiceImpl;
import com.project2.movieproject.user.OtherService;
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
import com.project2.movieproject.user.UserService;

@SessionAttributes("vo")
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
<<<<<<< HEAD
=======
	@Autowired
	OtherService service;

	
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	@ModelAttribute("vo")
	public UserVO setUserVO() {
		System.out.println("***********setUserVO()**********");
		return new UserVO();
	}
	
	@GetMapping("/userLogin")
	public String userLogin() {
		
		return "user/userLogin";
	}
	
	@GetMapping("/userRegist")
	public String userRegist() {
		
		return "user/userRegist";
	}
	
	@GetMapping("/userMypage")
	public String userMypage(@ModelAttribute("vo") UserVO vo, Model model) {
		String db_id = vo.getUser_id();
		System.out.println(vo.getUser_id());
		if(vo.getUser_id()==null) {
			return "redirect:/user/userLogin";
		}

		ArrayList<UserVO> userdata = userService.userdata(db_id);
		System.out.println(userdata);
		
<<<<<<< HEAD
		model.addAttribute("userdata", userdata);
=======
		ArrayList<qaVO> myqalist = userService.myqa_read(db_id);
		System.out.println(myqalist);
		
		model.addAttribute("userdata", userdata);
		model.addAttribute("myqalist", myqalist);
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
		return "user/userMypage";
	}
	
	@GetMapping("/userQnaRegist")
<<<<<<< HEAD
	public String userQnaRegist() {
		
		return "user/userQnaRegist";
	}
	
=======
	public String userQnaRegist(@ModelAttribute("vo") UserVO vo, Model model) {
		model.addAttribute("vo", vo);
		return "user/userQnaRegist";
	}
	
	@PostMapping("/qa_regist")
	public String qa_regist(qaVO vo, RedirectAttributes RA) {

		int result = userService.qa_regist(vo);
		System.out.println("sdkff");
		if(result == 1) { //성공
			RA.addFlashAttribute("msg", vo.getQa_title() + "이 정상 등록");
		} else { //실패
			RA.addFlashAttribute("msg", "등록 실패, 관리자에게 문의하세요.");
		}
		return "redirect:/user/userQnaRegist";
	}
	
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	@GetMapping("/userPhone")
	public String userPhone() {
		return "user/userPhone";
	}
	
	@PostMapping("/user_update_phone")
	public String user_update_phone(@ModelAttribute("vo") UserVO vo, UserVO newvo, Model model, RedirectAttributes RA) {
		String db_id = vo.getUser_id();
		ArrayList<UserVO> userdata = userService.userdata(db_id);
		
		newvo.setUser_id(db_id);
		System.out.println(newvo.getUser_id());
		System.out.println(newvo.getUser_phone());
		System.out.println(newvo.getUser_newphone());
		System.out.println(userdata.get(0).getUser_phone());
		
		if(newvo.getUser_phone().equals(userdata.get(0).getUser_phone())) {
			System.out.println("핸드폰번호 확인 완료");
			int result = userService.user_update(newvo);
			model.addAttribute("result", result);
			if(result == 1 ) {
				RA.addFlashAttribute("msg", vo.getUser_id() + "의 핸드폰번호가 변경되었습니다");
			} else {
				RA.addFlashAttribute("msg", "수정에 실패했습니다. 관리자에게 문의하세요");
			}
		} else {
			RA.addFlashAttribute("msg", "입력한 현재 핸드폰번호가 일치하지않습니다. 다시 시도해주세요.");
			System.out.println("번호가 일치하지 않음");
		}

		return "redirect:/user/userPhone";
	}
	
	@GetMapping("/userEmail")
	public String userEmail() {
		return "user/userEmail";
	}
	
	@PostMapping("/user_update_email")
	public String user_update_email(@ModelAttribute("vo") UserVO vo, UserVO newvo, Model model, RedirectAttributes RA) {
		String db_id = vo.getUser_id();
		ArrayList<UserVO> userdata = userService.userdata(db_id);
		
		newvo.setUser_id(db_id);
		System.out.println(newvo.getUser_id());
		System.out.println(newvo.getUser_email());
		System.out.println(newvo.getUser_newemail());
		System.out.println(userdata.get(0).getUser_email());
		
		if(newvo.getUser_email().equals(userdata.get(0).getUser_email())) {
			System.out.println("이메일 확인 완료");
			int result = userService.user_update(newvo);
			model.addAttribute("result", result);
			if(result == 1 ) {
				RA.addFlashAttribute("msg", vo.getUser_id() + "의 이메일이 변경되었습니다");
			} else {
				RA.addFlashAttribute("msg", "수정에 실패했습니다. 관리자에게 문의하세요");
			}
		} else {
			RA.addFlashAttribute("msg", "입력한 현재 이메일이 일치하지않습니다. 다시 시도해주세요.");
			System.out.println("이메일이 일치하지 않음");
		}

		return "redirect:/user/userEmail";
	}
	
	@GetMapping("/userPassword")
	public String userPassword() {
		return "user/userPassword";
	}
	
	@PostMapping("/user_update_password")
	public String user_update_password(@ModelAttribute("vo") UserVO vo, UserVO newvo, Model model, RedirectAttributes RA) {
		String db_id = vo.getUser_id();
		ArrayList<UserVO> userdata = userService.userdata(db_id);
		
		newvo.setUser_id(db_id);
		System.out.println(newvo.getUser_id());
		System.out.println(newvo.getUser_password());
		System.out.println(newvo.getUser_newpassword());
		System.out.println(userdata.get(0).getUser_password());
		
		if(newvo.getUser_password().equals(userdata.get(0).getUser_password())) {
			System.out.println("비밀번호 확인완료");
			int result = userService.user_update(newvo);
			model.addAttribute("result", result);
			if(result == 1 ) {
				RA.addFlashAttribute("msg", vo.getUser_id() + "의 비밀번호가 변경되었습니다");
			} else {
				RA.addFlashAttribute("msg", "수정에 실패했습니다. 관리자에게 문의하세요");
			}
		} else {
			RA.addFlashAttribute("msg", "입력한 현재 비밀번호가 일치하지않습니다. 다시 시도해주세요.");
			System.out.println("비밀번호가 일치하지 않음");
		}

		return "redirect:/user/userPassword";
	}
	
	@GetMapping("/userQnaRead")
<<<<<<< HEAD
	public String userQnaRead() {
=======
	public String userQnaRead(@RequestParam("qa_key") Integer qa_key, Model model) {
		ArrayList<qaVO> myqa = userService.qa_read(qa_key);
		model.addAttribute("myqa", myqa);
		
		
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
		return "user/userQnaRead";
	}
	
	@GetMapping("/userBirth")
	public String userBirth() {
		return "user/userBirth";
	}
	
<<<<<<< HEAD
	//회원가입 폼
	@PostMapping("/RegistForm")
	public String RegistForm(UserVO vo,
							 RedirectAttributes RA) {
		
		int result = userService.regist(vo);
		
		if(result == 1) { //성공
			RA.addFlashAttribute("msg", vo.getUser_id() + "이 정상 등록");
		} else { //실패
			RA.addFlashAttribute("msg", "등록 실패, 관리자에게 문의하세요.");
		}
		return "redirect:/user/userLogin";	//등록이후 로그인화면
=======
	@PostMapping("/user_update_birth")
	public String user_update_birth(@ModelAttribute("vo") UserVO vo, UserVO newvo, Model model, RedirectAttributes RA) {
		String db_id = vo.getUser_id();
		ArrayList<UserVO> userdata = userService.userdata(db_id);
		
		newvo.setUser_id(db_id);
		System.out.println(newvo.getUser_id());
		System.out.println(newvo.getUser_birth());
		System.out.println(newvo.getUser_newbirth());
		System.out.println(userdata.get(0).getUser_birth());
		
		if(newvo.getUser_birth().equals(userdata.get(0).getUser_birth())) {
			System.out.println("생년월일 확인 완료");
			int result = userService.user_update(newvo);
			model.addAttribute("result", result);
			if(result == 1 ) {
				RA.addFlashAttribute("msg", vo.getUser_id() + "의 생년월일이 변경되었습니다");
			} else {
				RA.addFlashAttribute("msg", "수정에 실패했습니다. 관리자에게 문의하세요");
			}
		} else {
			RA.addFlashAttribute("msg", "입력한 현재 생년월일이 일치하지않습니다. 다시 시도해주세요.");
			System.out.println("날짜가 일치하지 않음");
		}

		return "redirect:/user/userBirth";
	}
	
	//회원가입 폼
	@PostMapping("/RegistForm")
	public String RegistForm(UserVO vo,
							 RedirectAttributes RA, Model model) throws Exception {
		
		int result = userService.regist(vo);
		if(result == 1) { //성공
			ArrayList<UserVO> userdata = userService.userdata(vo.getUser_id());
			model.addAttribute("vo", userdata);
			RA.addFlashAttribute("msg", vo.getUser_id() + "이 정상 등록, 이메일인증 하세요.");
		} else { //실패
			RA.addFlashAttribute("msg", "등록 실패, 관리자에게 문의하세요.");
		}
		return "user/usermailCheck";	//등록이후 로그인화면
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	}
	
	//로그인 폼
	@PostMapping("/LoginForm")
	public String LoginForm(UserVO vo,
							RedirectAttributes RA,
							Model model) {
		String db_id = vo.getUser_id();
        int count_id = userService.idCheck(db_id);
		
		ArrayList<UserVO> userdata = userService.userdata(db_id);
<<<<<<< HEAD
		
		if(count_id > 0) { //성공
			if(vo.getUser_password().equals(userdata.get(0).getUser_password())) {
				RA.addFlashAttribute("msg", db_id + "이 정상 로그인");
				model.addAttribute("vo", userdata);
				return "redirect:userMypage";
			} else {

				RA.addFlashAttribute("msg", "로그인 실패, 관리자에게 문의하세요.");
				return "redirect:/user/userLogin";
			}
		} else { //실패
			RA.addFlashAttribute("msg", "등록 실패, 관리자에게 문의하세요.");
			return "redirect:/user/userLogin";
		}
=======

		if(userdata.get(0).isUser_auth()) {
			if(count_id > 0) { //성공
				if(vo.getUser_password().equals(userdata.get(0).getUser_password())) {
					RA.addFlashAttribute("msg", db_id + "이 정상 로그인");
					model.addAttribute("vo", userdata);
					if(userdata.get(0).isUser_admin() == true) {
						return "redirect:/admin/adminMain1";
					}
					return "redirect:/main";
				} else {

					RA.addFlashAttribute("msg", "로그인 실패,아이디와 비밀번호를 확인해주세요.");
					return "redirect:/user/userLogin";
				}
			} else { //실패
				RA.addFlashAttribute("msg", "로그인 실패, 아이디와 비밀번호를 확인하세요.");
				return "redirect:/user/userLogin";
			}
		} else {
			model.addAttribute("vo", userdata);
			RA.addFlashAttribute("msg", "이메일 인증이 안되어있습니다. 인증해주세요");
			return "redirect:/user/usermailCheck";
		}
		
		
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
	}
	
    // 아이디 체크
    @PostMapping("/idCheck")
<<<<<<< HEAD
    public String idCheck(UserVO vo, Model model, RedirectAttributes RA){
    	String id = vo.getUser_id();
        int cnt = userService.idCheck(id);
		model.addAttribute("cnt", cnt);
		model.addAttribute("check_id", id);
        
        if(cnt > 0) {
			RA.addFlashAttribute("msg", id + "은 중복");
			model.addAttribute("check_status", 0);
		} else {
			RA.addFlashAttribute("msg", id + "은 사용가능");
			model.addAttribute("check_status", 1);
		}
        
        
//        if(cnt != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
//            $('.id_ok').css("display","inline-block"); 
//            $('.id_already').css("display", "none");
//        } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
//            $('.id_already').css("display","inline-block");
//            $('.id_ok').css("display", "none");
//        }
        
        return "redirect:/user/userRegist";
    }
=======
    @ResponseBody
    public int idCheck(UserVO vo, Model model, RedirectAttributes RA, @RequestParam("id") String id){
        int cnt = userService.idCheck(id);
        return cnt;
    }
    
    // 계정 삭제
    @PostMapping("/user_drop")
    public String user_drop(@ModelAttribute("vo") UserVO vo, Model model, RedirectAttributes RA) {
    	int drop = userService.user_delete(vo);
    	
    	if(drop > 0) { //성공
				RA.addFlashAttribute("msg", vo.getUser_id() + "삭제되었습니다.");
				return "redirect:/user/userLogin";
		} else { //실패
			RA.addFlashAttribute("msg", "삭제 실패, 관리자에게 문의하세요.");
			return "redirect:/user/userLogin";
		}
    }
    
    @GetMapping("/userDetail")
    public String userDetail(@RequestParam("user_id") String dbid) {
    	
		ArrayList<UserVO> userdata = userService.userdata(dbid);
		System.out.println(userdata);
    	
    	return "user/userDetail";
    }
    
    @GetMapping("/userFind")
    public String userFind() {
    	return "user/userLogin";
    }
    
    
    @GetMapping("/userInfo")
    public String userInfo(Model model,Criteria cri) {
       
    
    	
      ArrayList<UserVO> userlist = userService.userlist(cri);
      int total =userService.total(cri);
      
      PageVO pageVO = new PageVO(cri,total);
      
      System.out.println(cri.getSearchType());
      System.out.println(cri.getSearchName());
      
      System.out.println(userlist);
      model.addAttribute("userlist", userlist);
      model.addAttribute("pageVO",pageVO);
       return "user/userInfo";
    }
    
    @GetMapping("/usermailCheck")
	public void emailConfirm(@ModelAttribute("vo") UserVO vo)throws Exception{
		service.sendSimpleMessage(vo.getUser_email());	
		System.out.println("전달 받은 이메일 : "+vo.getUser_email());
	}
    
    @PostMapping("/verifyCode")
	public String verifyCode(String code, @ModelAttribute("vo") UserVO vo, SessionStatus status, RedirectAttributes RA) {
		
		System.out.println("code : "+code);
		System.out.println(vo.getUser_email());
		System.out.println("code match : "+ EmailServiceImpl.ePw.equals(code));
		if(EmailServiceImpl.ePw.equals(code)) {
			RA.addFlashAttribute("msg", vo.getUser_id() + " 회원가입 성공");
			System.out.println(vo.isUser_auth());
			userService.auth_update(vo.getUser_id());
			System.out.println(vo.isUser_auth());
			
			status.setComplete();
			return "redirect:/user/userLogin";
		} else {
			int result = userService.user_delete(vo);
			if(result > 0) { //성공
				RA.addFlashAttribute("msg", vo.getUser_id() + "회원가입 실패. 다시 해주세요.");
				return "redirect:/user/userRegist";
		} else { //실패
			RA.addFlashAttribute("msg", "삭제 실패, 관리자에게 문의하세요.");
			return "redirect:/user/userLogin";
		}
		}
		
	}
    
    
>>>>>>> 13afea391c59459e24f216ee29cb0800a79dfc66
}
