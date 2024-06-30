package com.kb.shop.controller;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.domain.dto.CreateShippingInfoDto;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping("/shipping")
    public ResponseEntity<Map<String, String>> addShipping(@ModelAttribute CreateShippingInfoDto shippingDto) {
        ShippingInfo result = shippingService.save(shippingDto);

        Map<String, String> response = new HashMap<>();
        if (result == null) response.put("error", "order OR orderItem is NULL > Can not Save ShippingInfo");
        else response.put("result", String.valueOf(result));

        return ResponseEntity.ok().body(response);
    }

    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PutMapping("/shipping")
    public ResponseEntity<Map<String, String>> modifyShipping(@ModelAttribute("shipping") ShippingInfo shipping) {
        ShippingInfo result = shippingService.modify(shipping);
        Map<String, String> response = new HashMap<>();
        response.put("result", String.valueOf(result));

        return ResponseEntity.ok().body(response);
    }

    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
    @GetMapping("/shipping")
    public ResponseEntity<Map<String, String>> findShipping() {
        List<ShippingInfo> shippingInfos = shippingService.findAll();
        Map<String, String> response = new HashMap<>();
        response.put("result", String.valueOf(shippingInfos));

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/shipping/{id}")
    public ResponseEntity<Map<String, String>> findShippingById(@PathVariable Long id) {

        ShippingInfo shipping = shippingService.findById(id);
        Map<String, String> response = new HashMap<>();
        response.put("result", String.valueOf(shipping));

        return ResponseEntity.ok().body(response);
    }
}
