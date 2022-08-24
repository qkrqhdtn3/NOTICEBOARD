package com.example.board.jasypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JasyptTest {
//    @Value("${properties.test.value}")
    @Value("${spring.datasource.username}")
    private String propertiesTestValue;
//    private String propertiesTestValue = "ENC(osUlQXMHqFbHJ96EcnujtYaAm4XvMDjB)";

    public String getPropertiesTestValue(){
        return propertiesTestValue;
    }
}
