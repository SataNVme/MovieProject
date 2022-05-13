package com.project2.movieproject.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVO {
/*
	orderId varchar(50) not null,
    userId varchar(50) not null,
    orderRec varchar(50) not null,
    orderPhone varchar(30) not null,
    amount int not null,
    orderDate datetime,
    primary key(orderId)
*/	
	private String orderId;
	private String userId;
	private String orderRec;
	private String orderPhone;
	private int amount;
	private Date orderDate;
}
