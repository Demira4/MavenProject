package Lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthUserInOutTest extends AbstractTest{
//    @Test
//    void loginIn(){
//        new LJMainPage(getWebDriver()).goToAccountPage();
//        Assertions.assertTrue(getWebDriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
//        new LoginPage(getWebDriver())
//                .setLogin("kravmaxim@gmail.com")
//                .setPassword("vbPNKsk5GUFStb@")
//                .loginIn();
//        Assertions.assertTrue(getWebDriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
//
//    }

    @Test
    void loginIn(){
        new LJMainPage(getWebDriver()).goToAccountPage();
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5));
       // Assertions.assertTrue(getWebDriver().getTitle().equals("Главное - ЖЖ"), "страница входа недоступна");
        new LoginPage(getWebDriver())
                .loginIn("Iren234","Q5ZFNdGLigxqZxZ11");
        //Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@title='iren234']")).getAttribute("title").equals("iren234"));
    }



    @AfterEach
    void logout(){
        new LJMainPage(getWebDriver()).goOutAccountPage();
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(1));
        //Assertions.assertTrue(getWebDriver().getTitle().equals("Главное - ЖЖ"), "страница аккаунта не доступна");
        new AccountPage(getWebDriver()).logOut();
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5));
        //Assertions.assertTrue(getWebDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText().equals("Войти"));
    }



}
