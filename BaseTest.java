package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class BaseTest {
    public WebDriver driver;

@Before
public void setup () {
      System.setProperty("webdriver.chromedriver", "C:\\Users\\Korisnik\\Desktop\\Biljana September 2024\\NewPractise\\NewPractise\\lib\\chromedriver.exe");
//    ChromeOptions chromeOptions = new ChromeOptions();
//    chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
//    chromeOptions.addArguments("chrome.switches","--disable-extensions");
//    chromeOptions.addArguments("--disable-popup-blocking");
      driver = new ChromeDriver();
//      System.setProperty("webdriver.gekodriver", "C:\\Users\\Korisnik\\Desktop\\Biljana September 2024\\NopCommerce\\NopCommerce\\lib\\geckodriver.exe"); 
//      FirefoxOptions options = new FirefoxOptions();
//      driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
//    driver.get("https://www.google.com/");
    }

@After
    public void teardown() {
        driver.quit();
    }

}