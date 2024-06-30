package com.kb.shop.repository;

import com.kb.shop.domain.Product;
import com.kb.shop.domain.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<ShippingInfo, Long> {
}
