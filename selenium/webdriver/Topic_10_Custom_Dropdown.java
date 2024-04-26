package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //@Test
    public void TC_01_JQuery() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInDropdown("//span[@id='number-button']","//ul[@id='number-menu']/li/div","10");
        sleepInSeconds(3);

        selectItemInDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']/li/div","Slow");

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),"10");

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(),"Slow");

        }
        //@Test
        public void TC_02_React () {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropdown("//i[@class='dropdown icon']","//div//span[@class='text']","Stevie Feliciano");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Stevie Feliciano");
        sleepInSeconds(3);
        selectItemInDropdown("//i[@class='dropdown icon']","//div//span[@class='text']","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Jenny Hess");

        }
        //@Test
    public void TC_03_VueJS () {
            driver.get("https://mikerodham.github.io/vue-dropdowns/");
            selectItemInDropdown("//span[@class='caret']", "//ul[@class='dropdown-menu']/li/a", "Second Option");
            Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Second Option");
            sleepInSeconds(3);
            selectItemInDropdown("//span[@class='caret']", "//ul[@class='dropdown-menu']/li/a", "Third Option");
            Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Third Option");
        }
        @Test
     public void TC_04_Editable(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditableDropdown("//input[@class='search']","//div[@class='item']/span","Aland Islands");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Aland Islands");

     }
     //@Test
     public void TC_05_nopEcommerce(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");
        selectItemInDropdown("//select[@name='DateOfBirthDay']","//select[@name='DateOfBirthDay']/option","2");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text()='2']")).isSelected(),"2");
        sleepInSeconds(3);
        selectItemInDropdown("//select[@name='DateOfBirthMonth']","//select[@name='DateOfBirthMonth']/option","March");
         Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[text()='March']")).isSelected(),"March");
        sleepInSeconds(3);
        selectItemInDropdown("//select[@name='DateOfBirthYear']","//select[@name='DateOfBirthYear']/option","1994");
         Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[text()='1994']")).isSelected(),"1994");

         sleepInSeconds(3);
     }


        @AfterClass
        public void afterClass () {
            driver.quit();
        }

        public void sleepInSeconds ( long timeInSecond){
            try {
                Thread.sleep(timeInSecond * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        public void selectItemInDropdown(String parentXpath, String childItemXpath, String itemTextExpected){
            driver.findElement(By.xpath(parentXpath)).click();
            List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemXpath)));
            for (WebElement item : allItems) {
                if (item.getText().equals(itemTextExpected)) {
                    item.click();
                    break;
                }
            }


        }
        public void selectItemInEditableDropdown(String parentXpath, String childItemXpath,String itemTextExpected){
            driver.findElement(By.xpath(parentXpath)).clear();
            driver.findElement(By.xpath(parentXpath)).sendKeys(itemTextExpected);
            sleepInSeconds(1);
            List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemXpath)));
            for (WebElement item : allItems) {
                if (item.getText().equals(itemTextExpected)) {
                    item.click();
                    break;
                }
            }

        }

       }





