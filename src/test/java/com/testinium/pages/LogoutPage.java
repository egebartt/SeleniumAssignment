package com.testinium.pages;

import com.testinium.driver.BaseTest;
import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LogoutPage {
    Method method;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public LogoutPage(){
        method = new Method();
    }
    public void Logout(){
        method.click(By.cssSelector(".menu.top.login>ul>li>a.common-sprite"));
        method.scrollWithAction(By.cssSelector(".menu.top.login>ul>li>a.common-sprite"));
        method.click(By.xpath("//a[text()='Çıkış']"));
        logger.info("Çıkış Başarılı.");
    }


}
