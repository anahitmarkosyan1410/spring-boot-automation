package com.automation.demo;

import com.automation.demo.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Autowired
    LoginPage loginPage;

    @Test
    public void login() {
        System.out.println("Driver: " + driver);
        System.out.println("LoginPage: " + loginPage);

        if (loginPage != null) {
            driver.get("https://www.saucedemo.com");
            loginPage.login();
            System.out.println("Login test executed successfully!");
        } else {
            System.err.println("LoginPage bean is null!");
        }
    }
}
