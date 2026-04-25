package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Giữ nguyên các Xpath bạn đã cung cấp
    By txtEmail = By.xpath("//*[@id=\"input-10\"]");
    By txtPassword = By.xpath("//*[@id=\"input-13\"]");
    By btnLogin = By.xpath("/html/body/div/div/div/main/div/div[1]/div/div[3]/form/div[2]/button/span");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
}