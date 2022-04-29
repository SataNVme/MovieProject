package com.project2.movieproject.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieVO {
	
	private String movie_vUrl;
	private String movie_iUrl;
	private String movie_koficCd;
	private String movie_tmdbCd;
	private String movie_nm;
	private String movie_nmEn;
	private String movie_nmOr;
	private String movie_age;
	private String movie_dirNm;
	private String movie_dirNmEn;
	private String movie_actNm;
	private String movie_actNmEn;
	private String movie_gr;
	private String movie_nt;
	private String movie_openDt;
	private String movie_typeNm;
	private String movie_apiRt;
	private String movie_time;
	private String movie_ov;
	private Integer movie_siteRt;
	private Integer movie_sellPrice;
	private Integer movie_rentPrice;
	private Integer movie_views;
	private Integer movie_like;
	private Integer movie_dislike;
	private Integer movie_recommend;
	
	private String movieName;
	
}
