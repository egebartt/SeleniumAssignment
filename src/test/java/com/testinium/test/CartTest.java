package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.pages.CartPage;
import com.testinium.pages.LoginPage;
import com.testinium.pages.PaymentPage;
import com.testinium.pages.ProductPage;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Test
    public void CartTest() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        loginPage.login();
        productPage.goToHobby();
        productPage.randomProduct();
        productPage.addToCart();

        cartPage.goToCart();
        cartPage.productCountUpdate();
        cartPage.buyButton();
    }
}
