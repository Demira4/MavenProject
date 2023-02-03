package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class surfTest extends AbstractTest{
    @Test
    void surfTitleCategory (){
        //Проверка кликабельности меню второй линии
        getDriver().findElement(By.xpath("//*[@class='categories__list js--limited-list']/li[1]/a[1]")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("novye_lica"));
        Assertions.assertTrue(getDriver().getTitle().contains("Новые лица"), "страница входа недоступна");
        getDriver().findElement(By.xpath("//*[@class ='categories__list js--limited-list']/li[2]/a[1]")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("media_v_zhzh"));
        Assertions.assertTrue(getDriver().getTitle().contains("Медиа"), "страница входа недоступна");
        getDriver().findElement(By.xpath("//*[@class ='categories__list js--limited-list']/li[4]/a[1]")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("korotko"));
        Assertions.assertTrue(getDriver().getTitle().contains("Коротко"), "страница входа недоступна");
        getDriver().findElement(By.xpath("//*[@class ='categories__list js--limited-list']/li[5]/a[1]")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("video"));
        Assertions.assertTrue(getDriver().getTitle().contains("Видео"), "страница входа недоступна");
    }
}
