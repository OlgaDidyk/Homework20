import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.HashMap;

public class BaseTest {

    protected WebDriver driver;
    protected ContextMenuPage contextMenuPage;
    protected DynamicControlsPage dynamicControlsPage;
    protected FileUploadPage fileUploadPage;
    protected IFramePage iFramePage;
    protected FileDownloadPage fileDownloadPage;

    public static final String CONTENT_ROOT_PATH = "src/test/resources";
    public static final File FILE_PATH = new File(CONTENT_ROOT_PATH);
    public static final String ABSOLUTE_PATH = FILE_PATH.getAbsolutePath();
    File folder = new File(ABSOLUTE_PATH);

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", ABSOLUTE_PATH);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        iFramePage = new IFramePage(driver);
        fileDownloadPage = new FileDownloadPage(driver);

    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
