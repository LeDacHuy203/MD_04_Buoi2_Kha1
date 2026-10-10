package com.ecommerce.order.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {

    @NotNull(message = "customerId không được để trống")
    private Long customerId;

    @NotNull(message = "totalAmount không được để trống")
    @DecimalMin(value = "0.01", message = "Tổng tiền đơn hàng phải lớn hơn 0")
    private BigDecimal totalAmount;
}
