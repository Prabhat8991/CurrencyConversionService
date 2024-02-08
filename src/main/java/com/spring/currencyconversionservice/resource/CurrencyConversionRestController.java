package com.spring.currencyconversionservice.resource;

import com.spring.currencyconversionservice.model.CurrencyConversionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionRestController {

    @Autowired private Environment environment;

    @GetMapping("/currency-conversion/from/{from}/to/{to}")
    public CurrencyConversionInfo retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyConversionInfo currencyConversionInfo = new CurrencyConversionInfo(
                1000L,
                from,
                to,
                BigDecimal.valueOf(50)
        );
        currencyConversionInfo.setEnvironment(environment.getProperty("local.server.port"));
        return currencyConversionInfo;
    }
}
