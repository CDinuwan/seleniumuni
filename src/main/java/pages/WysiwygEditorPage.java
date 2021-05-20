package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId="mce_0_ifr";
    private By textArea=By.id("tinymce");
    private By decreaseIndentButton=By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver){
        this.driver=driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text2){
        switchToEditArea();
        driver.findElement(textArea).sendKeys();
        switchToMainArea();
    }

    public void decreaseIndentation(){
        driver.findElement(decreaseIndentButton).click();
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text=driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
