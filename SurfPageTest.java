package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SurfPageTest extends AbstractTest {

    @Test
    void mainMenuNavigateTest(){
        LJMainPage mainMenu = new LJMainPage(getWebDriver());
        mainMenu.navigateToNovyeLica();
        Assertions.assertTrue(getWebDriver().getTitle().contains("Новые лица"), "страница входа недоступна");
        mainMenu.navigateToMediaVzhzh();
        Assertions.assertTrue(getWebDriver().getTitle().contains("Медиа"), "страница входа недоступна");
        mainMenu.navigateToKorotko();
        Assertions.assertTrue(getWebDriver().getTitle().contains("Коротко"), "страница входа недоступна");
        mainMenu.navigateToVideo();
        Assertions.assertTrue(getWebDriver().getTitle().contains("Видео"), "страница входа недоступна");

        //Assertions.assertEquals("https://www.livejournal.com/",getWebDriver().getCurrentUrl());
    }
}
