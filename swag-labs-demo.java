package part1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void testLogin() throws InterruptedException {
        Thread.sleep(2000);
        WebElement user = driver.findElement(By.id("user-name"));
        user.sendKeys("standard_user");

        var pass = driver.findElement(By.name("password"));
        pass.sendKeys("secret_sauce");

        driver.findElement(By.className("btn_action")).click();
        Thread.sleep(2000);

        WebElement cart1 = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        new Actions(driver).moveToElement(cart1).click().build().perform();
        new Actions(driver).moveToElement(driver.findElement(By.tagName("path"))).click().build().perform();
        Thread.sleep(2000);
        new Actions(driver).moveToElement(driver.findElement(By.linkText("CHECKOUT"))).click().build().perform();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        Thread.sleep(2000);
        Action checkout = new Actions(driver).moveToElement(driver.findElement(By.xpath("//input[@value='CONTINUE']"))).click().build();
        checkout.perform();
        Thread.sleep(2000);
        new Actions(driver).keyDown(Keys.PAGE_DOWN);

        new Actions(driver).moveToElement(driver.findElement(By.linkText("FINISH"))).click().build().perform();


        String check = driver.findElement(By.className("subheader")).getText();
        String finish = "Finish";
        Assert.assertEquals(check, finish);
        System.out.println("Test Passed");





    }}

