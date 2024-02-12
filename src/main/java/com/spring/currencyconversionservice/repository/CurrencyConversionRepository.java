package com.spring.currencyconversionservice.repository;

import com.spring.currencyconversionservice.model.CurrencyConversionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversionInfo, Long> {
    CurrencyConversionInfo findByFromAndTo(String from, String to);
}
