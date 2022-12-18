package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    Method method;
    Logger logger = LogManager.getLogger(ProductPage.class);
    List<String> productList = new ArrayList<>();
    String productCount;

    public CartPage(){
        method = new Method();
    }

    public void goToCart() {
        method.waitBySeconds(1);
        method.click(By.id("sprite-cart-icon")); //sepete butonu
        method.waitBySeconds(1);
        method.click(By.id("js-cart")); // sepete git butonu
        logger.info("Sepete gidiş başarılı.");
    }
    public void productCountUpdate(){
        productCount = method.getAttribute(By.cssSelector("tr:first-child>.quantity>form>input:first-child"),"maxlength");

        method.sendKeys(By.cssSelector(".cart-info>table>tbody>tr:first-child>.quantity>form>input:first-child")
                , Keys.chord(Keys.CONTROL, "a"));
        if(productCount!="1"){
            method.sendKeys(By.cssSelector("input[name='quantity']"),"2");
        }else{
            method.sendKeys(By.cssSelector("input[name='quantity']"),"1");
        }
        method.click(By.cssSelector(".fa.fa-refresh.green-icon")); // Güncelle butonu
        logger.info("Ürün adedi güncelleme başarılı.");
    }
    public void buyButton() {
        method.click(By.cssSelector(".right>.button.red")); // Satın al butonu
        logger.info("Satın al butonu başarılı.");
    }
}
