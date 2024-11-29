package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver driver) {
    super (driver);
    }

    String baseUrl = "https://demo.nopcommerce.com/";
    By loginIconBy = By.className("ico-login");
 

}
