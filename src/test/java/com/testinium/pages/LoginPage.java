package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Method method;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public LoginPage(){
        method = new Method();

    }
    public void login(){
        method.click(By.cssSelector(".menu-top-button.login>a"));
        method.click(By.cssSelector("button#js-popup-accept-button"));
        method.sendKeys(By.id("login-email"),"egebartu.teker@testinium.com");
        method.sendKeys(By.xpath("//input[@id='login-password']"),"a1s2d3f4g5");
        //method.waitBySeconds(3);
        method.click(By.xpath("//button[@class='ky-btn ky-btn-orange w-100 ky-login-btn']"));
        //method.waitBySeconds(3);

        logger.info("Çalıştı");
    }
    public void loginControl(){
        Assert.assertTrue(method.isElementVisible(By.cssSelector(".section")));
        method.waitBySeconds(2);
    }


}
