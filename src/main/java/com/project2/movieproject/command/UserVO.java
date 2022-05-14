package com.project2.movieproject.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
	private Integer user_key;
	private LocalDateTime user_date;
	private String user_id;
	private Integer user_gender;
	private String user_birth;
	private String user_email;
	private boolean user_auth;
	private boolean user_admin;
	private String user_name;
	private String user_phone;
	private String user_password;
	private String user_newemail;
	private String user_newphone;
	private String user_newpassword;
	private String user_newbirth;
	
	private Integer year;
	private Integer month;
	private Integer count;
	
	private String movie_koficcd;
	private String movie_koficCd;
	private String movie_nm;
	private String movie_iurl;
}
