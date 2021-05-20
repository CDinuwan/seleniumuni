package base;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Chanuka Dinuwan\\Desktop\\webdriver_java\\src\\test\\resources\\chromedriver.exe");
        driver=new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.get("https://the-internet.herokuapp.com/");
        setCookie();

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

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void takeScreenshot(){
        var camera=(TakesScreenshot)driver;
        File screenshot=camera.getScreenshotAs(OutputType.FILE);
        try{
            Files.move(screenshot,new File("C:\\Users\\Chanuka Dinuwan\\Desktop\\webdriver_java\\src\\main\\resources\test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options =new ChromeOptions();
        options.addArguments("disable-infobars");
//        options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie=new Cookie.Builder("TAU","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
