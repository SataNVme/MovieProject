package com.project2.movieproject.moviepayment;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "movieOrder") //테이블 이름 order는 불가능하므로
public class MovieOrder {
	/*
	CREATE TABLE MOVIEORDER (
			ID INT AUTO_INCREMENT PRIMARY KEY,
			USER_NAME VARCHAR(10) NOT NULL,
			MOVIE_NM VARCHAR(50) NOT NULL, ##영화이름(한글)
			MOVIE_SELLPRICE INT, ##판매가격
		    MOVIE_RENTPRICE INT, ##대여가격
		    CREATEDDATE DATETIME
		    );
	*/	    
    @Id 
    @GeneratedValue
    @Column(name = "order_id")
    private int id;                            		 //order pk
    private String user_name;                        //주문자
    private String movie_nm;                        //주문 상품
    private int movie_sellPrice;					//주문 가격
    private int movie_rentPrice;                    // 주문 가격
    private LocalDateTime createdDate;              //주문 시간
}