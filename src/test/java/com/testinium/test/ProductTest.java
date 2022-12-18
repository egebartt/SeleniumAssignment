package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.pages.*;
import org.junit.*;


public class ProductTest extends BaseTest {


    @Test
    public void searchProductTest(){
        ProductPage productPage = new ProductPage();
        productPage.searchProduct();
    }

    @Test
    public void MyFavoriteTest(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        loginPage.login();
        productPage.searchProduct();
        productPage.scrollToElement();
        productPage.addToFavorite();
        productPage.refreshPage();
        productPage.addedToFavoritesControl();
        productPage.goToMyFavorites();
        productPage.removeFromMyFavorites();
    }



}
