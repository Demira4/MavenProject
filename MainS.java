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



public class MainS {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");
        //нажимаем кнопку "войти"
        WebElement buttonEnter = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        buttonEnter.click();
        // Login_pass("Iren234", "Q5ZFNdGLigxqZxZ");

//авторизация пользователя
        WebElement userEnter = driver.findElement(By.id("user"));
        userEnter.click();
        userEnter.sendKeys("Iren234");
        //WebElement passEnter = driver.findElement(By.name("password"));
        WebElement passEnter= driver.findElement(By.id("lj_loginwidget_password"));
        passEnter.click();
        passEnter.sendKeys("Q5ZFNdGLigxqZxZ11");
        WebElement rememberMe = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
        rememberMe.click();
        WebElement enterUser =driver.findElement((By.name("action:login")));
        enterUser.click();

        sleep(10);
        //написать статью для себя
        WebElement writeArticle = driver.findElement(By.xpath("//*[@class='s-do']/li[4]/a[1]"));
        writeArticle.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("post"));
        //всплывающее окно "Открыть черновик" отказываемся

        driver.findElement(By.xpath("//*[@class='buttons-0-2-309']/button[1]")).click(); // кнопка "нет"
        //печатаем заголовок
        WebElement titleArticle = driver.findElement(By.xpath("//*[@class='text-0-2-179']"));
        titleArticle.click();
        titleArticle.sendKeys("Сложности тестирования");
        //печатаем текст
        WebElement article = driver.findElement(By.xpath("//*[@role='textbox']"));
        article.sendKeys("На обучении тебя бросают в открытый интернет и там ты должен отработать полученные знания. Но в открытом доступе не обучающие страницы. Поэтому будешь сталкиваться с блокировками");
        // в кнопке "виден всем" выбираем "только я"
        WebElement visionVar = driver.findElement(By.xpath("//*[@class='primSxn-0-2-236']/div[1]/button[1]/span[1]"));
        visionVar.click();
        new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement vision = driver.findElement(By.xpath("//*[@class='root-0-2-314']/li[4]/label[1]"));
        vision.click();
        //нажимаем на кнопку "настроить и опубликовать"
        WebElement publicButton = driver.findElement(By.xpath("//*[@class='primSxn-0-2-236']/div[2]/button[1]/span[1]"));
        publicButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(1));
        //нажимаем на кнопку "опубликовать"
        WebElement publicButton2 = driver.findElement(By.xpath("//*[@class='footer-0-2-264 root-0-2-359']/div[1]/button[1]/span[1]"));
       // publicButton2.click(); - проверила 1 раз-работает. закомментировала, чтобы не плодить одинаковые статьи, чтобы не заблокировали

        //выход из учетной записи
        WebElement buttonUser = driver.findElement(By.cssSelector(".s-header-item--user"));
        Actions action = new Actions(driver);
        action.moveToElement(buttonUser);
        action.perform();
        WebElement exitUser = driver.findElement(By.xpath("//*[@class='s-do']/li[2]/ul/li[15]/a"));
        exitUser.click();
        


//        справочный материал
//        Alert alert = new WebDriverWait(driver,Duration.ofSeconds(1)).until(alertIsPresent());
//        alert.accept();
//        alert.
//        Actions action1 = new Actions(driver);
//        action1.moveToElement(publicButton);
//        action1.perform();
        //*[@class='primSxn-0-2-236']/div[2]/div[1]/div/div[2]/label[1] - кнопка выбрать дату



    }
    public static void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }
}
