package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Xpath_CSS {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC_Register_02_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Viet Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("1234@1213@2323");
        driver.findElement(By.id("txtCEmail")).sendKeys("1234@1213@2323");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0988892928");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void TC_Register_03_Invalid_Confirm_Email() {
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtEmail")).sendKeys("nviet0610@gmail.com");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void TC_Register_04_Invalid_Password() {
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtCEmail")).sendKeys("nviet0610@gmail.com");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

    }
    @Test
    public void TC_Register_05_Invalid_Confirm_Password() {
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }
    @Test
    public void TC_Register_06_Invalid_Phone_Number() {
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("096322471");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");


        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("096322471456");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");


        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1234567891");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ'and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }




    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
