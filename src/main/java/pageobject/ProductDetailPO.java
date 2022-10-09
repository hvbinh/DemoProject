package pageobject;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageui.NewProductPageUI;
import pageui.ProductDetailPageUI;

public class ProductDetailPO extends BasePage {
    WebDriver driver;

    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }


    public String getProductQuantity() {
        waitToElementVisible(driver, ProductDetailPageUI.UNIT_MEASURE_VALUE);
        return getElementText(driver, ProductDetailPageUI.UNIT_MEASURE_VALUE);
    }

    public HomePO clickToHomeMenu() {
        waitToElementClickable(driver, ProductDetailPageUI.HOME_MENU);
        clickToElement(driver, ProductDetailPageUI.HOME_MENU);
        return PageGeneratorManager.getHomePage(driver);
    }
}
