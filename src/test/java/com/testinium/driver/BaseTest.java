package com.testinium.driver;

import com.testinium.pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-translate");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        driver.get("https://www.kitapyurdu.com/");

    }
    @Test
    public void allTest(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        PaymentPage paymentPage = new PaymentPage();
        LogoutPage logoutPage = new LogoutPage();

        loginPage.login();
        productPage.searchProduct();
        productPage.scrollToElement();
        productPage.addToFavorite();
        productPage.refreshPage();
        productPage.addedToFavoritesControl();
        productPage.backToMainPage();
        productPage.pointsCatalog();
        productPage.turkClassics();
        productPage.filter();
        productPage.goToHobby();
        productPage.randomProduct();
        productPage.addToCart();
        productPage.goToMyFavorites();
        productPage.removeFromMyFavorites();

        cartPage.goToCart();
        cartPage.productCountUpdate();
        cartPage.buyButton();

        paymentPage.addAddressButton();
        paymentPage.fillAddressInfo();
        paymentPage.continueButton();
        paymentPage.continueButton();
        paymentPage.creditCard();
        paymentPage.continueButton();
        paymentPage.creditCartControl();
        productPage.backToMainPage();
        logoutPage.Logout();

    }
    @After
    public void TearDown(){
        if(driver!=null){
            //driver.close();
            driver.quit();
        }
    }



}
