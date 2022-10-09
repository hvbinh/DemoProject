package pageobject;

import common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageui.NewManufacturingPageUI;

public class NewManufacturingPO extends BasePage {
    WebDriver driver;

    public NewManufacturingPO(WebDriver driver) {
        this.driver = driver;
    }


    public ManufacturingDetailPO clickToSaveButton() {
        waitToElementClickable(driver, NewManufacturingPageUI.SAVE_BUTTON);
        clickToElement(driver, NewManufacturingPageUI.SAVE_BUTTON);
        return PageGeneratorManager.getManufacturingDetailPage(driver);
    }


    public void inputToProductNameField(String productName) {
        waitToElementClickable(driver, NewManufacturingPageUI.PRODUCT_INPUT);
        sendkeyToElement(driver, NewManufacturingPageUI.PRODUCT_INPUT, productName);
        sendKeyBoardToElement(driver, NewManufacturingPageUI.PRODUCT_INPUT, Keys.ENTER);
        sleepInSecond(2);
    }
}
