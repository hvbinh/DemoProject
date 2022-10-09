package pageobject;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageui.InventoryPageUI;
import pageui.ProductPageUI;

public class InventoryPO extends BasePage {
    WebDriver driver;

    public InventoryPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToProductsTopMenu() {
        waitToElementClickable(driver, InventoryPageUI.PRODUCT_TOP_MENU);
        clickToElement(driver, InventoryPageUI.PRODUCT_TOP_MENU);
    }

    public ProductPO clickToProductsItem() {
        waitToElementClickable(driver, InventoryPageUI.PRODUCT_ITEM);
        clickToElement(driver, InventoryPageUI.PRODUCT_ITEM);
        return PageGeneratorManager.getProductPage(driver);
    }
}
