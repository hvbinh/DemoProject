package pageobject;

import common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageui.ManufacturingPageUI;
import pageui.ProductDetailPageUI;

public class ManufacturingPO extends BasePage {
    WebDriver driver;

    public ManufacturingPO(WebDriver driver) {
        this.driver = driver;
    }


    public NewManufacturingPO clickToCreateButton() {
        waitToElementClickable(driver, ManufacturingPageUI.CREATE_BUTTON);
        clickToElement(driver, ManufacturingPageUI.CREATE_BUTTON);
        return PageGeneratorManager.getNewManufacturingPage(driver);
    }

    public void clickToManufacturingOrderCloseIcon() {
        waitToElementClickable(driver, ManufacturingPageUI.CLOSE_MANUFACTURING_ORDER_ICON);
        clickToElement(driver, ManufacturingPageUI.CLOSE_MANUFACTURING_ORDER_ICON);
    }

    public void inputToSearchField(String manufacturingOrderName) {
        waitToElementClickable(driver, ManufacturingPageUI.SEARCH_INPUT);
        sendkeyToElement(driver, ManufacturingPageUI.SEARCH_INPUT, manufacturingOrderName);
        sendKeyBoardToElement(driver, ManufacturingPageUI.SEARCH_INPUT, Keys.ENTER);
        sleepInSecond(3);
    }

    public String getManufacturingOrderName() {
        waitToElementVisible(driver, ManufacturingPageUI.MANUFACTURING_ORDER_NAME_IN_TABLE);
        return getElementText(driver, ManufacturingPageUI.MANUFACTURING_ORDER_NAME_IN_TABLE);
    }

    public String getProductName() {
        waitToElementVisible(driver, ManufacturingPageUI.PRODUCT_NAME_IN_TABLE);
        return getElementText(driver, ManufacturingPageUI.PRODUCT_NAME_IN_TABLE);
    }

    public String getTotalQuantity() {
        waitToElementVisible(driver, ManufacturingPageUI.TOTAL_QUANTITY_IN_TABLE);
        return getElementText(driver, ManufacturingPageUI.TOTAL_QUANTITY_IN_TABLE);
    }

    public String getManufacturingOrderQuantitySale() {
        waitToElementVisible(driver, ManufacturingPageUI.QUANTITY_SALE_IN_TABLE);
        return getElementText(driver, ManufacturingPageUI.QUANTITY_SALE_IN_TABLE);
    }

    public String getManufacturingOrderStatus() {
        waitToElementVisible(driver, ManufacturingPageUI.MANUFACTURING_ORDER_STATUS_IN_TABLE);
        return getElementText(driver, ManufacturingPageUI.MANUFACTURING_ORDER_STATUS_IN_TABLE);
    }
}
