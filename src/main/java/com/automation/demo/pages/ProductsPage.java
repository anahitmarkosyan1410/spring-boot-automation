package com.automation.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {

    @FindBy(linkText = "Sauce Labs Backpack")
    private WebElement product;
}
