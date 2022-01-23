import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage {

    public static final String BASE_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public static final By DYNAMIC_CONTROL_TITLE = By.cssSelector("body>div>div>div>h4:first-child");//body/div/div/div/h4[contains(text(),'Dynamic')]
    public static final By CHECKBOX_LOCATOR = By.cssSelector("input[type='checkbox']");
    public static final By REMOVE_BUTTON = By.cssSelector("[onclick='swapCheckbox()']");
    public static final By ENABLE_BUTTON = By.cssSelector("[onclick='swapInput()']");
    public static final By INPUT_FIELD = By.cssSelector("input[type='text']");
    public static final By MESSAGE = By.cssSelector("#message");


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = DYNAMIC_CONTROL_TITLE;
    }

    public void pushBtn(By locator) {
        driver.findElement(locator).click();
    }
}
