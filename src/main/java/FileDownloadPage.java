import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloadPage extends BasePage {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/download";
    private static final By FILE_DOWNLOADER_TITLE = By.tagName("h3");

    public FileDownloadPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = FILE_DOWNLOADER_TITLE;
    }

    public void downloadFileTest(String text) {
        driver.findElement(By.partialLinkText(text)).click();
    }
}
