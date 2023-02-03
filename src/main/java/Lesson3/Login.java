package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver driver = new ChromeDriver();
    WebElement loginUser = driver.findElement(By.id("user"));
    WebElement passUser = driver.findElement((By.name("password")));
    WebElement rememberMe = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
    WebElement enterUser =driver.findElement((By.name("action:login")));

    public void Login (String login, String pass){
        loginUser.sendKeys(login);
        passUser.sendKeys(pass);
        rememberMe.click();
        enterUser.click();
    }



}
