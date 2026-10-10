package com.ecommerce.order.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    private Long id;
    private String orderNumber;
    private Long customerId;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime createdAt;
}
