package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WriteArticle extends AbstractPage {

    @FindBy(xpath = "//*[@class='s-do']/li[4]/a[1]")
    private WebElement napisatStatiu;
    @FindBy(xpath = "//*[@class='buttons-0-2-309']/button[1]")
    private WebElement buttonNo;
    @FindBy(xpath = "//*[@class='text-0-2-179']")
    private WebElement zagolovokStatiu;
    @FindBy(xpath = "//*[@role='textbox']")
    private WebElement textBoxStatiu;

    //@FindBy(xpath = "//*[@class='primSxn-0-2-236']/div[1]/button[1]/span[1]")
    @FindBy(xpath = "//span[text()='Виден всем']")
    private WebElement buttonVarVision;
    @FindBy(xpath = "//label[text() ='Только я']")
    private WebElement visionOnlyI;
    @FindBy(xpath = "//*[@class='primSxn-0-2-236']/div[2]/button[1]/span[1]")
    private WebElement nastroit;
    @FindBy(xpath = "//*[@class='footer-0-2-264 root-0-2-359']/div[1]/button[1]/span[1]")
    private WebElement opublikovat;

    public WriteArticle(WebDriver driver) {
        super(driver);
    }

    public void clickButtonNapisatStatiu() {
        napisatStatiu.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("post"));
    }

    public void clickNoChernovik() {
        buttonNo.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("post"));
    }

    public void wrAr(String Zagolovok, String text) {
        Actions write = new Actions(getDriver());
        write.click(this.zagolovokStatiu)
                .sendKeys(Zagolovok)
                .pause(1000)
                .click(this.textBoxStatiu)
                .sendKeys(text)
                .pause(1000)
                .click(this.buttonVarVision)
                .pause(1000)
                .click(this.visionOnlyI)
                .pause(1000)
                .click(this.nastroit)
                .build()
                .perform();
        //opublikovat.click(); // не нажимаю, чтобы не заблокировали аккаунт
    }
}
