import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/upload";
    private static final By FILE_UPLOADER_TITLE = By.tagName("h3");
    private static final By BROWSE_BUTTON = By.id("file-upload");
    private static final By UPLOAD_BUTTON = By.id("file-submit");


    public FileUploadPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = FILE_UPLOADER_TITLE;
    }

    public void uploadFile(String filePath) {
        driver.findElement(BROWSE_BUTTON).sendKeys(filePath);
    }

    public void pushUploadBtn() {
        driver.findElement(UPLOAD_BUTTON).click();

    }
}
