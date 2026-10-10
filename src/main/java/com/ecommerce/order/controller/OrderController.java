package com.ecommerce.order.controller;

import com.ecommerce.order.dto.request.OrderRequestDTO;
import com.ecommerce.order.dto.response.BaseResponse;
import com.ecommerce.order.dto.response.OrderResponseDTO;
import com.ecommerce.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * API Health Check: Kiểm tra tình trạng hoạt động của service
     * URL: GET /api/v1/orders/health-check
     * @return Chuỗi "Order Service is Up"
     */
    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        // Tuân thủ SRP: Controller chỉ tiếp nhận request và gọi Service, không tự xử lý logic
        String status = orderService.healthCheck();
        return ResponseEntity.ok(status);
    }

    /**
     * API Tạo mới đơn hàng
     * URL: POST /api/v1/orders
     */
    @PostMapping
    public ResponseEntity<BaseResponse<OrderResponseDTO>> createOrder(@Valid @RequestBody OrderRequestDTO requestDTO) {
        OrderResponseDTO createdOrder = orderService.createOrder(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.ok("Tạo đơn hàng thành công", createdOrder));
    }

    /**
     * API Lấy chi tiết đơn hàng theo ID
     * URL: GET /api/v1/orders/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<OrderResponseDTO>> getOrderById(@PathVariable Long id) {
        OrderResponseDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(BaseResponse.ok("Lấy thông tin đơn hàng thành công", order));
    }
}
