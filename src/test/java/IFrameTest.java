import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {

    @Test
    public void iFramePageTest() {
        iFramePage.open();
        iFramePage.isPageLoaded();
        iFramePage.wait.until(ExpectedConditions.visibilityOf(driver.findElement(IFramePage.IFRAME_NAME)));
        driver.switchTo().frame(driver.findElement(IFramePage.IFRAME_NAME));
        iFramePage.wait.until(ExpectedConditions.visibilityOf(driver.findElement(IFramePage.IFRAME_PLACEHOLDER_LOCATOR)));
        Assert.assertEquals(driver.findElement(IFramePage.IFRAME_PLACEHOLDER_LOCATOR).getText(),
                IFramePage.IFRAME_PLACEHOLDER_TEXT,
                "IFrame text is not valid");
        //driver.switchTo().defaultContent(); - come back to the main html document
    }

}
