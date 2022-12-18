package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.pages.CartPage;
import com.testinium.pages.LoginPage;
import com.testinium.pages.PaymentPage;
import com.testinium.pages.ProductPage;
import org.junit.Test;

public class PaymentTest extends BaseTest {

    @Test
    public void PaymentTest(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        PaymentPage paymentPage = new PaymentPage();
        CartPage cartPage = new CartPage();

        loginPage.login();

        cartPage.goToCart();
        cartPage.buyButton();

        paymentPage.addAddressButton();
        paymentPage.fillAddressInfo();
        paymentPage.continueButton();
        paymentPage.continueButton();
        paymentPage.creditCard();
        paymentPage.continueButton();
        paymentPage.creditCartControl();
        paymentPage.clickLogo();
    }
}
