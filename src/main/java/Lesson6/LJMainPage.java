package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LJMainPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='categories__list js--limited-list']/li[1]/a[1]")
    private WebElement novyeLica;

    @FindBy(xpath = "//*[@class ='categories__list js--limited-list']/li[2]/a[1]")
    private WebElement mediaVzhzh;

    @FindBy(xpath = "//*[@class ='categories__list js--limited-list']/li[4]/a[1]")
    private WebElement korotko;

    @FindBy(xpath = "//*[@class ='categories__list js--limited-list']/li[5]/a[1]")
    private WebElement video;

    @FindBy(css = ".s-header-item__link--login")
    private WebElement signIn;

    @FindBy(css = ".s-header-item--user")
    private WebElement buttonUser;

    @FindBy(xpath = "//*[@class='s-do']/li[2]/ul/li[15]/a")
    private WebElement singOut;

    public LJMainPage(WebDriver driver) {
        super(driver);

    }

    public void goToAccountPage() {
        signIn.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.livejournal.com/"));

    }
    public void goOutAccountPage(){
        Actions loginOut = new Actions(getDriver());
        loginOut
                .moveToElement(buttonUser)
                .build()
                .perform();
        //singOut.click();
    }

    public void navigateToNovyeLica() {
        this.novyeLica.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("novye_lica"));
    }

    public void navigateToVideo() {
        this.video.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("video"));
    }

    public void navigateToKorotko() {
        this.korotko.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("korotko"));
    }

    public void navigateToMediaVzhzh() {
        this.mediaVzhzh.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("media_v_zhzh"));
    }
}

