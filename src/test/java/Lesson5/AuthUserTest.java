package Lesson5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthUserTest extends AbstractTest {
    @Test

    void  buttonEnterUserTest () {

        getDriver().findElement(By.cssSelector(".s-header-item__link--login")).click();
        Actions enterUser  = new Actions(getDriver());
        enterUser
                .sendKeys(getDriver().findElement(By.id("user")), "Iren234")
               // .pause(1000)
                .sendKeys(getDriver().findElement(By.name("password")),"Q5ZFNdGLigxqZxZ11")
               // .pause(1000)
                .click(getDriver().findElement(By.cssSelector(".b-loginform-checkbox__control")))
               // .pause(1000)
                .click(getDriver().findElement(By.name("action:login")))
                .build()
                .perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        boolean hasName=false;

        List <WebElement> webElements = getDriver().findElements(By.xpath("//*[@title='iren234']"));
        if(webElements.size()>=1){
            hasName = true;
            } else hasName = false;

        Assertions.assertEquals(true,hasName, "Вход пользователя не выполнен");

        WebElement buttonUser = getDriver().findElement(By.cssSelector(".s-header-item--user"));
        Actions action = new Actions(getDriver());
        action.moveToElement(buttonUser)
                .build()
                .perform();
        getDriver().findElement(By.xpath("//*[@class='s-do']/li[2]/ul/li[15]/a")).click();
        Assertions.assertEquals(true, hasName, "Выход из учетной записи не выполнен");



    }

}
