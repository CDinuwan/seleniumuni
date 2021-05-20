package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoginPage{
    private WebDriver driver;
    private String linkXpath_Format=".//a[contains(text(),'%s')";
    private By link_Example1=By.xpath(String.format(linkXpath_Format,"Example 1"));

    public DynamicLoginPage(WebDriver driver){
        this.driver=driver;
    }
    public DynamicLoadingExamplePage clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExamplePage(driver);
    }
}
