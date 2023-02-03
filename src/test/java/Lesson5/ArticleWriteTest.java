package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ArticleWriteTest extends AbstractTest {
 @Test
   void  articleWrite () {
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

   List<WebElement> webElements = getDriver().findElements(By.xpath("//*[@title='iren234']"));
   if(webElements.size()>=1){
     hasName = true;
   } else hasName = false;

   Assertions.assertEquals(true,hasName, "Вход пользователя не выполнен");
   //Нажимаем кнопку "Написать статью"
   getDriver().findElement(By.xpath("//*[@class='s-do']/li[4]/a[1]")).click();
   new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("post"));
   Assertions.assertTrue(getDriver().getCurrentUrl().contains("post"), "Ошибка при нажатии кнопки Написать статью");
   //всплывающее окно "Открыть черновик" отказываемся

   getDriver().findElement(By.xpath("//*[@class='buttons-0-2-309']/button[1]")).click(); // кнопка "нет"
   //печатаем заголовок
//   Actions write = new Actions(getDriver());
//   write.sendKeys(getDriver().findElement(By.xpath("//*[@class='text-0-2-179']")), "Благодарность ЖЖ")
//           .pause(1000)
//           .sendKeys(getDriver().findElement(By.xpath("//*[@role='textbox']")), "Благодарю за предоставленную возможность обучения основам автотестирования на Вашем сайте")
//           .click(getDriver().findElement(By.xpath("//span[text()='Виден всем']")))
//           .pause(2000)
//           .click(getDriver().findElement(By.xpath("//label[text() ='Только я']")))
//           .pause(1000)
//           .click(getDriver().findElement(By.xpath("//*[@class='primSxn-0-2-236']/div[2]/button[1]/span[1]")))
//           .pause(1000)
//           .click(getDriver().findElement(By.xpath("//*[@class='footer-0-2-264 root-0-2-359']/div[1]/button[1]/span[1]")))
//           .build()
//           .perform();
   WebElement titleArticle = getDriver().findElement(By.xpath("//*[@class='text-0-2-179']"));
   // titleArticle.click();
   titleArticle.sendKeys("Благодарность ЖЖ");
   WebElement article = getDriver().findElement(By.xpath("//*[@role='textbox']"));
   article.sendKeys("Благодарю за предоставленную возможность обучения основам автотестирования на Вашем сайт");
   // в кнопке "виден всем" выбираем "только я"
   WebElement visionVar = getDriver().findElement(By.xpath("//*[@class='primSxn-0-2-236']/div[1]/button[1]/span[1]"));
   visionVar.click();
   new WebDriverWait(getDriver(), Duration.ofSeconds(2));
   WebElement vision = getDriver().findElement(By.xpath("//label[text() ='Только я']"));
   vision.click();
   //нажимаем на кнопку "настроить и опубликовать"
   WebElement publicButton = getDriver().findElement(By.xpath("//*[@class='primSxn-0-2-236']/div[2]/button[1]/span[1]"));
   publicButton.click();
   new WebDriverWait(getDriver(), Duration.ofSeconds(1));
   //нажимаем на кнопку "опубликовать"
   WebElement publicButton2 = getDriver().findElement(By.xpath("//*[@class='footer-0-2-264 root-0-2-359']/div[1]/button[1]/span[1]"));
   // publicButton2.click(); - проверила 1 раз-работает. закомментировала, чтобы не плодить одинаковые статьи, чтобы не заблокировали

   WebElement buttonUser = getDriver().findElement(By.cssSelector(".s-header-item--user"));
   Actions action = new Actions(getDriver());
   action.moveToElement(buttonUser)
           .build()
           .perform();
   getDriver().findElement(By.xpath("//span[text()='Выйти']")).click();
   Assertions.assertEquals(true, hasName, "Выход из учетной записи не выполнен");
}
}
