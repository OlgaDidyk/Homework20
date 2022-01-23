import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContextMenuTest extends BaseTest {

    public void openContextMenuPage() {
        contextMenuPage.open();
        Assert.assertTrue(contextMenuPage.isPageLoaded(), "Context Menu page is not loaded");
    }

    @Test
    public void validAlertTextTest() {
        openContextMenuPage();
        contextMenuPage.clickOnElement();
        contextMenuPage.wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,
                ContextMenuPage.ALERT_TEXT, "Incorrect text in alert");
        driver.switchTo().alert().accept();
        openContextMenuPage();

    }
}
