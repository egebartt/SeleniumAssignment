package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.*;

public class ProductPage {
    Method method;
    Logger logger = LogManager.getLogger(ProductPage.class);
    List<String> productList = new ArrayList<>();
    String productCount;

    public ProductPage(){
        method = new Method();
    }


    public void searchProduct(){
        method.waitBySeconds(2);
        method.sendKeys(By.id("search-input"), "Oyuncak");
        method.click(By.cssSelector(".common-sprite.button-search"));
        logger.info("Ürün araması başarılı.");
    }
    public void scrollToElement(){
        method.scrollWithAction(By.xpath("(//div[@class='product-list']/div[@class='product-cr'])[7]"));
        logger.info("scroll ile ürüne gitme başarılı.");
    }

    public void addToFavorite(){
        for(int i=0;i<4;i++){
            String product = method.getAttribute(By.cssSelector(".product-list>.product-cr:nth-child("+(i+4)+")"),"id");
            productList.add(product);

            method.click(By.cssSelector(".product-list>.product-cr>.grid_2.alpha.omega.relative>.hover-menu>a[onclick='addToFavorites("
                    +product.substring(8)+");']"));
            //method.waitBySeconds(2);
        }
        logger.info("Favorilerime ekleme başarılı.");
        //method.waitBySeconds(3);
    }
    public void refreshPage() {
        method.refreshPage();
    }
    public void addedToFavoritesControl(){
        for(int i=0;i<4;i++) {
            String FavoriteStatus = method.getAttribute(By.cssSelector(".product-list>.product-cr:nth-child("
                            +(i+4)+")>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"), "style");

            Assert.assertTrue(""+(i+1)+". ürün favorilerde ekli değil!",FavoriteStatus.equals("display: none;"));
        }
        logger.info("Favorilere Eklendi");
    }
    public void backToMainPage() {
        method.mainPage("https://www.kitapyurdu.com/");
        logger.info("Anasayfaya gidiş başarılı.");
    }

    public void pointsCatalog(){
        method.click(By.cssSelector(".lvl1catalog>.common-sprite"));
        logger.info("Puan katalogu'na gidiş başarılı.");
    }

    public void turkClassics(){
        method.click(By.xpath("(//div[@class='landing-block']/a/img)[2]"));
        logger.info("Turk Klasikleri'ne gidiş başarılı.");
    }

    public void filter(){
        method.selectByText(By.cssSelector(".sort>select[onchange]"),"Yüksek Oylama");
        logger.info("'Yüksek Oylama' filtresi başarılı.");
    }

    public void goToHobby(){
        method.waitBySeconds(1);
        method.hover(By.xpath("//li[starts-with(@class, has-open-menu)]/span[text()='Tüm Kitaplar']"));
        method.click(By.xpath("//a[text()='Hobi']"));
        logger.info("Hobi'ye gidiş başarılı.");
    }

    public void randomProduct(){
        Random random = new Random();
        int number = random.nextInt(1,20);
        method.click(By.xpath("(//ul[@class='product-grid jcarousel-skin-opencart']/li)["+number+"]"));
        logger.info("Random ürün seçimi başarılı.");
    }
    public void addToCart(){
        method.click(By.cssSelector(".pr_cart.product-info>#button-cart"));
        logger.info("Kart'a ekleme başarılı.");
        method.waitBySeconds(1);
    }
    public void goToMyFavorites(){
        method.click(By.xpath("//div[@class='menu top my-list']"));
        method.click(By.xpath("//a[text()='Favorilerim']"));

        method.click(By.xpath("//span[starts-with(@class,'display-item sprite')]"));
        // change appearance of the productlist
        logger.info("Favorilerim'e gidiş başarılı.");
    }
    public void removeFromMyFavorites(){
        method.click(By.cssSelector(".hover-menu>a[onclick='removeFromFavorites("
                +productList.get(2).substring(8)+");']"));
        method.waitBySeconds(2);
        logger.info("Favorilerden silme başarılı.");
    }


}
