package com.automation.demo;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver driver;

//    @Autowired
//    private ApplicationContext context;
//
//    @Test
//    public void printBeans() {
//        System.out.println("==== Beans in Spring Context ====");
//        for (String beanName : context.getBeanDefinitionNames()) {
//            System.out.println(beanName);
//        }
//        System.out.println("===============================");
//    }

    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
