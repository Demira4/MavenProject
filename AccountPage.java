package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy (css = ".s-header-item__link--login")
    private WebElement singIn;

    @FindBy(xpath = "//*[@class='s-do']/li[2]/ul/li[15]/a")
    private WebElement exit;

    public AccountPage(WebDriver driver){
        super(driver);

    }
    public void logIn(){
        this.singIn.click();
    }

    public void logOut(){
        this.exit.click();

    }

}
