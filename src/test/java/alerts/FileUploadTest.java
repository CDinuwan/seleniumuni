package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest{

    @Test
    public void testFileUpload(){
        var uploadPage=homePage.clickFileUpload();
        uploadPage.uploadFile("\"C:\\\\Users\\\\Chanuka Dinuwan\\\\Desktop\\\\webdriver_java\\\\src\\\\test\\\\resources\\\\chromedriver.exe");
        assertEquals(uploadPage=homePage.clickFileUpload(),"chromedriver.exe","Upload valid file");

    }
}
