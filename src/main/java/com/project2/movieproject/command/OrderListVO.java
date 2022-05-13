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
public class OrderListVO {
	private String orderId;
	private String userId;
	private String orderRec;
	private String orderPhone;
	private int amount;
	private Date orderDate;
	private int orderDetailsNum;
	private String itemName;
	private int itemPrice;
}
