package pageobject;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageui.ManufacturingDetailPageUI;

public class ManufacturingDetailPO extends BasePage {
    WebDriver driver;

    public ManufacturingDetailPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToConfirmOkButton() {
        waitToElementClickable(driver, ManufacturingDetailPageUI.CONFIRM_OK_BUTTON);
        clickToElement(driver, ManufacturingDetailPageUI.CONFIRM_OK_BUTTON);
        sleepInSecond(2);
    }

    public void clickToConfirmApplyButton() {
        waitToElementClickable(driver, ManufacturingDetailPageUI.CONFIRM_APPLY_BUTTON);
        clickToElement(driver, ManufacturingDetailPageUI.CONFIRM_APPLY_BUTTON);

    }

    public void clickToMarkAsDoneButton() {
        waitToElementClickable(driver, ManufacturingDetailPageUI.MARK_AS_DONE_BUTTON);
        clickToElementByJS(driver, ManufacturingDetailPageUI.MARK_AS_DONE_BUTTON);
    }

    public void clickToConfirmButton() {
        waitToElementClickable(driver, ManufacturingDetailPageUI.CONFIRM_BUTTON);
        clickToElement(driver, ManufacturingDetailPageUI.CONFIRM_BUTTON);
        sleepInSecond(3);
    }

    public String getManufacturingOrderName() {
        waitToElementVisible(driver, ManufacturingDetailPageUI.MANUFACTURING_ORDER_VALUE);
        sleepInSecond(3);
        return getElementText(driver, ManufacturingDetailPageUI.MANUFACTURING_ORDER_VALUE);
    }

    public String getProductName() {
        waitToElementVisible(driver, ManufacturingDetailPageUI.PRODUCT_NAME_VALUE);
        return getElementText(driver, ManufacturingDetailPageUI.PRODUCT_NAME_VALUE);
    }

    public String getProductQuantity() {
        waitToElementVisible(driver, ManufacturingDetailPageUI.QUANTITY_VALUE);
        return getElementText(driver, ManufacturingDetailPageUI.QUANTITY_VALUE);
    }


    public boolean isManufacturingOrderDone() {
        waitToElementVisible(driver, ManufacturingDetailPageUI.DONE_STATUS);
        return isElementDisplayed(driver, ManufacturingDetailPageUI.DONE_STATUS);
    }

    public ManufacturingPO clickToManufacturingMenu() {
        waitToElementClickable(driver, ManufacturingDetailPageUI.MANUFACTURING_MENU);
        clickToElement(driver, ManufacturingDetailPageUI.MANUFACTURING_MENU);
        return PageGeneratorManager.getManufacturingPage(driver);
    }

    public String getManufacturingOrderQuantitySale() {
        waitToElementVisible(driver, ManufacturingDetailPageUI.QUANTITY_SALE_VALUE);
        return getElementText(driver, ManufacturingDetailPageUI.QUANTITY_SALE_VALUE);
    }
}
