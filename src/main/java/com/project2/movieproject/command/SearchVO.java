package com.project2.movieproject.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchVO {
	
	private String movie_koficCd; // 영진위
	private String movie_nm; // 영화명
	private String movie_dirNm; // 감독명
	private String movie_actNm; // 배우명
	private String movie_ov; // 영화 소개
	
}
