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

    public WebElement getButtonNo() {
        return buttonNo;
    }

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
    //public void getButtonNo(){

    //}

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
        write
                .click(this.zagolovokStatiu)
                .sendKeys(this.zagolovokStatiu, Zagolovok)
                .pause(1000)
                .click(this.textBoxStatiu)
                .sendKeys(this.textBoxStatiu,text)
                .pause(1000)
                .click(this.buttonVarVision)
                .pause(1000)
                .click(this.visionOnlyI)
                .pause(1000)
                .click(this.nastroit)
                .build()
                .perform();
        //opublikovat.click(); // не нажимаю, чтобы не заблокировали аккаунт

//        WebElement titleArticle = getDriver().findElement(By.xpath("//*[@class='text-0-2-179']"));
//        // titleArticle.click();
//        titleArticle.sendKeys(Zagolovok);
//
//        WebElement article = getDriver().findElement(By.xpath("//*[@role='textbox']"));
//        article.sendKeys(text);
//        // в кнопке "виден всем" выбираем "только я"
//        WebElement visionVar = getDriver().findElement(By.xpath("//*[@class='primSxn-0-2-236']/div[1]/button[1]/span[1]"));
//        visionVar.click();
//        new WebDriverWait(getDriver(), Duration.ofSeconds(2));
//        WebElement vision = getDriver().findElement(By.xpath("//label[text() ='Только я']"));
//        vision.click();
//        //нажимаем на кнопку "настроить и опубликовать"
//        WebElement publicButton = getDriver().findElement(By.xpath("//*[@class='primSxn-0-2-236']/div[2]/button[1]/span[1]"));
//        publicButton.click();
//        new WebDriverWait(getDriver(), Duration.ofSeconds(1));
//        //нажимаем на кнопку "опубликовать"
//        WebElement publicButton2 = getDriver().findElement(By.xpath("//*[@class='footer-0-2-264 root-0-2-359']/div[1]/button[1]/span[1]"));
//        // publicButton2.click(); - проверила 1 раз-работает. закомментировала, чтобы не плодить одинаковые статьи, чтобы не заблокировали

    }
}
