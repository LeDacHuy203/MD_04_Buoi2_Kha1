package com.ecommerce.order.service;

import com.ecommerce.order.dto.request.OrderRequestDTO;
import com.ecommerce.order.dto.response.OrderResponseDTO;

public interface OrderService {

    /**
     * Kiểm tra tình trạng hoạt động của Order-Service
     * @return Chuỗi "Order Service is Up"
     */
    String healthCheck();

    /**
     * Tạo mới đơn hàng
     */
    OrderResponseDTO createOrder(OrderRequestDTO requestDTO);

    /**
     * Lấy chi tiết đơn hàng theo ID
     */
    OrderResponseDTO getOrderById(Long id);
}
