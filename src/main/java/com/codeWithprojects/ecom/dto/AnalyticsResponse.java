package com.codeWithprojects.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnalyticsResponse {

	private Long placed;
	
	private Long shipped;
	
	private Long delivered;
	
	
	private Long currentMonthOrders;
	
	private Long previousMonthOrders;
	
	private Long currentMonthsEarning;
	
	private Long previousMonthEarnings;
}
