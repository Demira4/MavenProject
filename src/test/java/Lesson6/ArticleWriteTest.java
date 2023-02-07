package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArticleWriteTest extends AbstractTest {

    @Test
    void ArticleWriteTest(){
        new LJMainPage(getWebDriver()).goToAccountPage();
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5));
        // Assertions.assertTrue(getWebDriver().getTitle().equals("Главное - ЖЖ"), "страница входа недоступна");
        new LoginPage(getWebDriver())
                .loginIn("Iren234","Q5ZFNdGLigxqZxZ11");
        new WriteArticle(getWebDriver()).clickButtonNapisatStatiu();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("post"), "Ошибка при нажатии кнопки Написать статью");
        new WriteArticle(getWebDriver()).clickNoChernovik();
        new WriteArticle(getWebDriver()).wrAr("Thanks", "Выражаю особую благодарность журналу ЖЖ в практике тестирования Веб-сайтов");
        new LJMainPage(getWebDriver()).goOutAccountPage();
    }
}
