package com.project2.movieproject.controller;

import java.util.ArrayList;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project2.movieproject.command.Criteria;
import com.project2.movieproject.command.PageVO;
import com.project2.movieproject.command.UserVO;
import com.project2.movieproject.command.qaVO;
import com.project2.movieproject.user.UserService;

@SessionAttributes("vo")
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
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
		
		ArrayList<qaVO> myqalist = userService.myqa_read(db_id);
		System.out.println(myqalist);
		
		model.addAttribute("userdata", userdata);
		model.addAttribute("myqalist", myqalist);
		return "user/userMypage";
	}
	
	@GetMapping("/userQnaRegist")
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
	public String userQnaRead(@RequestParam("qa_title") String qa_title, Model model) {
		ArrayList<qaVO> myqa = userService.qa_read(qa_title);
		model.addAttribute("myqa", myqa);
		
		
		return "user/userQnaRead";
	}
	
	@GetMapping("/userBirth")
	public String userBirth() {
		return "user/userBirth";
	}
	
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
							 RedirectAttributes RA) {
		
		int result = userService.regist(vo);
		
		if(result == 1) { //성공
			RA.addFlashAttribute("msg", vo.getUser_id() + "이 정상 등록");
		} else { //실패
			RA.addFlashAttribute("msg", "등록 실패, 관리자에게 문의하세요.");
		}
		return "redirect:/user/userLogin";	//등록이후 로그인화면
	}
	
	//로그인 폼
	@PostMapping("/LoginForm")
	public String LoginForm(UserVO vo,
							RedirectAttributes RA,
							Model model) {
		String db_id = vo.getUser_id();
        int count_id = userService.idCheck(db_id);
		
		ArrayList<UserVO> userdata = userService.userdata(db_id);
		
		if(count_id > 0) { //성공
			if(vo.getUser_password().equals(userdata.get(0).getUser_password())) {
				RA.addFlashAttribute("msg", db_id + "이 정상 로그인");
				model.addAttribute("vo", userdata);
				return "redirect:/main";
			} else {

				RA.addFlashAttribute("msg", "로그인 실패,아이디와 비밀번호를 확인해주세요.");
				return "redirect:/user/userLogin";
			}
		} else { //실패
			RA.addFlashAttribute("msg", "로그인 실패, 아이디와 비밀번호를 확인하세요.");
			return "redirect:/user/userLogin";
		}
	}
	
    // 아이디 체크
    @PostMapping("/idCheck")
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
    
    
    
}
