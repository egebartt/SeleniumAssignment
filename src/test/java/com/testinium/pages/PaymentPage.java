package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PaymentPage {

    Method method;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public PaymentPage(){
        method = new Method();
    }
    public void addAddressButton(){
        method.click(By.cssSelector("a[onclick=\"setShippigAddressType('new')\"]"));
        logger.info("Adres ekle butonu başarılı.");
    }
    public void fillAddressInfo(){
        method.sendKeys(By.cssSelector("input#address-firstname-companyname"),"ege bartu");
        method.sendKeys(By.cssSelector("input#address-lastname-title"),"teker");
        method.selectByText(By.cssSelector("select#address-zone-id"),"Balıkesir");
        method.selectByText(By.cssSelector("select#address-county-id"),"AYVALIK");
        method.sendKeys(By.cssSelector("input#district"),"150 EVLER MAH");
        method.sendKeys(By.cssSelector("textarea#address-address-text"),"Ayvalık");
        method.sendKeys(By.cssSelector("input#address-postcode"),"10400");
        method.sendKeys(By.cssSelector("input#address-mobile-telephone"),"5123456789");
        method.click(By.cssSelector("button#button-checkout-continue"));
        logger.info("Adres bilgilerinin doldurulması başarılı.");
    }
    public void continueButton(){
        method.click(By.cssSelector("button#button-checkout-continue"));
        method.waitBySeconds(2);
        logger.info("Devam et butonu başarılı.");
    }
    public void creditCard() {
        method.sendKeys(By.cssSelector("input#credit-card-owner"), "ege bartu teker");
        method.sendKeys(By.cssSelector("input#credit_card_number_1"), "4346");
        method.sendKeys(By.cssSelector("input#credit_card_number_2"), "2800");
        method.sendKeys(By.cssSelector("input#credit_card_number_3"), "0334");
        method.sendKeys(By.cssSelector("input#credit_card_number_4"), "0382");
        method.selectByText(By.cssSelector("select#credit-card-expire-date-month"), "09");
        method.selectByText(By.cssSelector("select#credit-card-expire-date-year"), "2026");

        method.sendKeys(By.cssSelector("input#credit-card-security-code"), "487");
        logger.info("Kredi kartı bilgilerinin doldurulması başarılı.");
        method.waitBySeconds(3);
    }

    public void creditCartControl() {
        boolean control = method.isElementVisible(By.xpath("//span[text()='Kart numarası geçersiz. Kontrol ediniz!']"));
        Assert.assertTrue("Hatalı kart bilgileri girilmeli",control==true);
        logger.info("Geçersiz kart bilgilerinin girilmesi başarılı.");
    }
    public void clickLogo(){
        method.click(By.cssSelector(".checkout-logo"));
        logger.info("Anasa logosu butonu başarılı.");
    }


}
