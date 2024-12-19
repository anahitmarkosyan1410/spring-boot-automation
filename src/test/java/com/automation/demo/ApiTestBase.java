package com.automation.demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiTestBase {

    @Autowired
    ConfigManager configManager;

    @BeforeAll
    public void setUp(){
        RestAssured.baseURI = configManager.getRestBaseURI();
        RestAssured.port = configManager.getRestPort();
        RestAssured.basePath = configManager.getRestBasePath();

    }
}
