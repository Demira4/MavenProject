package Lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");
        WebElement buttonEnter = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        buttonEnter.click();
        // Login_pass("Salery2233", "Q5ZFNdGLigxqZxZ");

//авторизация пользователя
        WebElement userEnter = driver.findElement(By.id("user"));
        userEnter.click();
        userEnter.sendKeys("Salery2233");
        WebElement passEnter = driver.findElement(By.name("password"));
        passEnter.click();
        passEnter.sendKeys("Q5ZFNdGLigxqZxZ");
        WebElement rememberMe = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
        rememberMe.click();
        WebElement enterUser =driver.findElement((By.name("action:login")));
        enterUser.click();

        sleep(10);
// кликаем по меню второй линии
        WebElement aNewFace = driver.findElement(By.xpath("//*[@class='categories__list js--limited-list']/li[1]/a[1]"));
        aNewFace.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("novye_lica"));
        WebElement aMedia = driver.findElement(By.xpath("//*[@class ='categories__list js--limited-list']/li[2]/a[1]"));
        aMedia.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("media_v_zhzh"));
        WebElement aKorotko = driver.findElement(By.xpath("//*[@class ='categories__list js--limited-list']/li[4]/a[1]"));
        aKorotko.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("korotko"));
        WebElement aVideo = driver.findElement(By.xpath("//*[@class ='categories__list js--limited-list']/li[5]/a[1]"));
        aVideo.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("video"));
        //сделала клики по 4 ссылкам, далее аналогично
        //выход из учетной записи
        WebElement buttonUser = driver.findElement(By.cssSelector(".s-header-item--user"));
        Actions action = new Actions(driver);
        action.moveToElement(buttonUser);
        action.perform();
        WebElement exitUser = driver.findElement(By.xpath("//*[@class='s-do']/li[2]/ul/li[15]/a"));
        exitUser.click();
    }
    public static void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }


}
