package com.codeWithprojects.ecom.services.admin.adminorder;

import java.util.List;

import com.codeWithprojects.ecom.dto.AnalyticsResponse;
import com.codeWithprojects.ecom.dto.OrderDto;

public interface AdminOrderService {
	
	List<OrderDto> getAllPlacedOrders();

	OrderDto changeOrderStatus(Long orderId, String status);
	
	AnalyticsResponse calculateAnalytics();
}
