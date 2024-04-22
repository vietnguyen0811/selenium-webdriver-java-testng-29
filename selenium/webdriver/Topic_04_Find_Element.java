package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Find_Element {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() {
        driver.get("http://live.techpanda.org/");
        //driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='My Account']/ancestor::div[@class='footer']")).click();

        driver.get("https://demo.nopcommerce.com");
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        //driver.findElement(By.xpath("//ul[@class='sublist']//a[text()='Desktops ']")).click();
        driver.findElement(By.xpath("//ul[@class='sublist']//a[contains(text(),'Desktops ')]")).click();
        //driver.findElement(By.xpath("//button[starts-with(@id,'empty_cart')]")).click();
        //driver.findElement(By.xpath("//button[contains(@id,'empty_cart')]")).click();
    }

    public void TC_02() {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
