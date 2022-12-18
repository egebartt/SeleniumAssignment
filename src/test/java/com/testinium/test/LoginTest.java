package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        loginPage.loginControl();
    }

}

