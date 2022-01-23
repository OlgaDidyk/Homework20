import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    private final String CONTENT_ROOT_PATH = "src/test/resources/Unit 10.doc";

    @Test
    public void uploadFileTest() {
        fileUploadPage.open();
        fileUploadPage.isPageLoaded();
        File filepath = new File(CONTENT_ROOT_PATH);
        String absolutePath = filepath.getAbsolutePath();
        String fileName = filepath.getName();
        fileUploadPage.uploadFile(absolutePath);
        fileUploadPage.pushUploadBtn();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), fileName,
                "Uploaded file name is incorrect");
    }

}
