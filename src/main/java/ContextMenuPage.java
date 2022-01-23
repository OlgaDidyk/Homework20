import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/context_menu";
    public static final String ALERT_TEXT = "You selected a context menu";
    private static final By CONTEXT_ELEMENT = By.id("hot-spot");
    private static final By CONTEXT_MENU_TITLE = By.tagName("h3");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = CONTEXT_MENU_TITLE;
    }

    Actions actions = new Actions(driver);

    public void clickOnElement() {
        actions.contextClick(driver.findElement(CONTEXT_ELEMENT)).perform();
    }

}