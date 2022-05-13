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
public class OrderDetailVO {
/*	
	orderDetailsNum int not null auto_increment primary key,
    orderId varchar(50) not null,
    itemName varchar(50) not null
*/
	private int orderDetailNum;
	private String orderId;
	private String itemName;
}
