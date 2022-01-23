import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    public void openDynamicControlsPage() {
        dynamicControlsPage.open();
        Assert.assertEquals(driver.findElement(DynamicControlsPage.DYNAMIC_CONTROL_TITLE).getText(),
                "Dynamic Controls",
                "Dynamic Controls page is not loaded");
    }

    @Test
    public void dynamicControlTest() {
        openDynamicControlsPage();
        Assert.assertTrue(driver.findElement(DynamicControlsPage.CHECKBOX_LOCATOR).isDisplayed(),
                "Checkbox is not displayed");
        dynamicControlsPage.pushBtn(DynamicControlsPage.REMOVE_BUTTON);
        dynamicControlsPage.wait.until(ExpectedConditions.invisibilityOf(driver.findElement(DynamicControlsPage.CHECKBOX_LOCATOR)));
        Assert.assertTrue(driver.findElements(DynamicControlsPage.CHECKBOX_LOCATOR).isEmpty(),
                "Checkbox is presented");
        Assert.assertFalse(driver.findElement(DynamicControlsPage.INPUT_FIELD).isEnabled());
        dynamicControlsPage.pushBtn(DynamicControlsPage.ENABLE_BUTTON);
        dynamicControlsPage.wait.until(ExpectedConditions.textToBe(DynamicControlsPage.MESSAGE, "It's enabled!"));
        Assert.assertTrue(driver.findElement(DynamicControlsPage.INPUT_FIELD).isEnabled());
    }
}
