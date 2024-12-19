package com.automation.demo.pages;

import com.automation.demo.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {
    ConfigManager configManager;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Autowired
    public LoginPage(WebDriver driver, ConfigManager configManager) {
        super(driver);
        this.configManager = configManager;
    }

    public void login(){
        logger.info("Login with " + configManager.getUserName());
        webDriver.get(configManager.getBaseUrl());
        sendKeys(userName,configManager.getUserName());
        sendKeys(password,configManager.getPassword());
        click(loginButton);
        logger.info("User logged sucessfull");
    }
}
