package tests;

import org.junit.Test;
import org.openqa.selenium.Alert;

import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {
    public RegistrationPage registrationPage;
    
    public String validFirstName = "Biljana";
    public String validLastName = "Krstic";
    public String validEmail = "bpetrovic987@gmail.com";
    public String validPassword = "lozinka";
    public String validConfirmPassword = "lozinka";
    public String validDayOfBirth = "19";
    public String validMonthOfBirth = "7";
    public String validYearOfBirth = "1987";
    public String companyName = "New company"; 

    @Test
    public void successfulRegistration () {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.basePage();
        registrationPage.clickOnLoginButton();
        registrationPage.clickOnIAmHuman();
        registrationPage.clickOnRegisterIcon();
        registrationPage.clickOnIAmHuman();
        registrationPage.fillPersonalInformation(validFirstName, validLastName, validEmail, validPassword, validConfirmPassword);
        registrationPage.fillInCompanyNameField(companyName);
        registrationPage.enterDateOfBirth();
        
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
    }
    }

