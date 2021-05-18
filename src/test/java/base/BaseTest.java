package base;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.List;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Chanuka Dinuwan\\Desktop\\webdriver_java\\src\\test\\resources\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

//        driver.manage().window().fullscreen();
//
//      driver.manage().window().setSize(new Dimension(375,812));
//
//        WebElement inputsLink=driver.findElement(By.linkText("Inputs"));
//        inputsLink.click();
//
//        List<WebElement> links=driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//
//        System.out.println(driver.getTitle());

        homePage=new HomePage(driver);

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
