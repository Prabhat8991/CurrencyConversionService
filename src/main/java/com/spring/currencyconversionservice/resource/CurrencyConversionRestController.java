package com.spring.currencyconversionservice.resource;

import com.spring.currencyconversionservice.model.CurrencyConversionInfo;
import com.spring.currencyconversionservice.repository.CurrencyConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionRestController {

    @Autowired
    private Environment environment;

    @Autowired
    CurrencyConversionRepository currencyConversionRepository;

    @GetMapping("/currency-conversion/from/{from}/to/{to}")
    public CurrencyConversionInfo retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyConversionInfo currencyConversionInfo = currencyConversionRepository.findByFromAndTo(from, to);
        if (currencyConversionInfo == null) {
            throw new RuntimeException("Could not find currency conversion values for " + from + " and " + to);
        }
        currencyConversionInfo.setEnvironment(environment.getProperty("local.server.port"));
        return currencyConversionInfo;
    }
}
