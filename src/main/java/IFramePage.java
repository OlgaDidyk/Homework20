import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePage {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/iframe";
    public static final By IFRAME_TITLE = By.cssSelector("div [class='example']");
    public static final By IFRAME_PLACEHOLDER_LOCATOR = By.tagName("p");
    public static final String IFRAME_PLACEHOLDER_TEXT = "Your content goes here.";
    public static final By IFRAME_NAME = By.id("mce_0_ifr");

    public IFramePage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = IFRAME_TITLE;
    }

}
