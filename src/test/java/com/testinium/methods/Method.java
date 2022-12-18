package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class Method {

    WebDriver driver;
    Actions actions;

    FluentWait<WebDriver> wait;

    Logger logger = LogManager.getLogger(Method.class);

    public Method(){
    driver = BaseTest.driver;
    actions = new Actions(driver);
    wait = new FluentWait<>(driver);
    wait.withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofMillis(300))
            .ignoring(NoSuchElementException.class);

    }

    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void mainPage(String url){
        driver.get(url);
    }

    public void click(By by){
        findElement(by).click();
    }

    public void hover(By by){
        WebElement hover = driver.findElement(by);
        actions.moveToElement(hover).perform();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void waitBySeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("true");
            return true;
        }catch(Exception e){
            logger.info("false" + e.getMessage());
            return false;
        }
    }

    public void scrollWithAction(By by){
            actions.moveToElement(findElement(by)).build().perform();
    }

    public Select getSelect(By by){ // dropbox için
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){ // dropbox'taki textler
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName){
        return findElement(by).getAttribute(attributeName);
    }

}
