package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class RegistrationPage extends BasePage {
    public RegistrationPage (WebDriver driver) {
        super(driver);
    }
    
    String baseUrl = "https://demo.nopcommerce.com/";
    By languageIconBy = By.className("navigation-top-menu-item");
    By registerIconBy = By.className("ico-register");
    By registerTextBy = By.xpath("//*[@id=\'main\']/div/div/div/div[1]/h1");
    By yourPersonalDetailsTextBy = By.xpath("//*[@id=\'main\']/div/div/div/div[2]/form/div[1]/div[1]/strong");
    By genderMaleBy = By.id("gender-male");
    By genderFemaleBy = By.id("gender-female");
    By firstNameFieldBy = By.id("FirstName");
    By lastNameFieldBy = By.id("LastName");
    By dayOfBirthBy = By.xpath("//*[@id=\'main\']/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    By monthOfBirthBy = By.xpath("//*[@id=\'main\']/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    By yearOfBirthBy = By.xpath("//*[@id=\'main\']/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]");
    By emailFieldBy = By.xpath("//*[@id=\'Email\']");
    By companyNameFieldBy = By.xpath("//*[@id=\'Company\']");
    By newsletterBy = By.xpath("//*[@id=\'Newsletter\']");
    By passwordFieldBy = By.id("Password");
    By confirmPasswordFieldBy = By.id("ConfirmPassword");
    By registerButtonBy = By.id("register-button"); 
    By youAreHumanButtonBy = By.xpath("/div/div/div[1]/div/label/input");
    By loginButtonBy = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");

        private Select dropdown;
    
        public RegistrationPage clickOnRegisterIcon() {
            click(registerIconBy);
            return this;
        }
    
        public RegistrationPage verifyRegisterFormIsOpened (String expectedText) {
            String actualText = readText(yourPersonalDetailsTextBy);
            assertTextEquals(expectedText, actualText);
            return this;
        }
    
        public RegistrationPage fillPersonalInformation (String firstName, String lastName, String email, String password, String confirmPassword) {
            writeText(firstNameFieldBy, firstName);
            writeText(lastNameFieldBy, lastName);
            writeText(emailFieldBy, email);
            writeText(passwordFieldBy, password);
            writeText(confirmPasswordFieldBy, confirmPassword);
            return this;
        }
    
        public RegistrationPage clickOnRegisterButton () {
            click(registerButtonBy);
            return this;
        }

        public RegistrationPage clickOnLoginButton() {
            click(loginButtonBy);
            return this;
        }
    
        public RegistrationPage fillInCompanyNameField (String companyName) {
            writeText(companyNameFieldBy, companyName);
            return this;
        }
    
        public void enterDateOfBirth (){
            waitVisability(dayOfBirthBy);
            click(dayOfBirthBy);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement Element = driver.findElement(By.linkText("19"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
        }
    
        public void checkNewsletter (By elementBy){
            if (!driver.findElement(elementBy).isSelected()){
                driver.findElement(elementBy).click();
            }
        }
    
        public void uncheckNewsletter (By elementBy) {
            if (driver.findElement(elementBy).isSelected()) {
                driver.findElement(elementBy).click();
            }
        }
    
        public RegistrationPage basePage () {
            driver.get(baseUrl);
            return this;
        }
    
        public RegistrationPage clickOnIAmHuman () { 
            waitUntilClickable(youAreHumanButtonBy);
            click(youAreHumanButtonBy);
            return this;
        } 
    
    
        public RegistrationPage sorting () {
              // Get all options
        List<WebElement> allOptionsElement = dropdown.getOptions();

    // Creating a list to store drop down options
    List options = new ArrayList();


    for(WebElement optionElement : allOptionsElement)
    {
        options.add(optionElement.getText());
    }

    // Removing "Please select" option as it is not actual option
    options.remove("Please select");

    System.out.println("Options in dropdown with Default order :"+options);

    // Creating a temp list to sort
    List tempList = new ArrayList(options);

    Collections.sort(tempList);

    System.out.println("Sorted List "+ tempList);

    boolean ifSortedAscending = options.equals(tempList);

    if(ifSortedAscending)
    {
        System.out.println("List is sorted");
    }
    else
        System.out.println("List is not sorted.");
        return this;
    }
}

