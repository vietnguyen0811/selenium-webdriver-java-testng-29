package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() {
        driver.get("http://live.techpanda.org/");

    }


    public void TC_02() {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
