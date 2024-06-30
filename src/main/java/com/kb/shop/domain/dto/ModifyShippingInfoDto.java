package com.kb.shop.domain.dto;

import com.kb.shop.domain.enums.ShippingStatus;
import lombok.Data;

@Data
public class ModifyShippingInfoDto {

    private Long orderId;

    private Long orderItemId;

    private ShippingStatus shippingStatus;
}
