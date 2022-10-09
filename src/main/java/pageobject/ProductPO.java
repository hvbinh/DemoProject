package pageobject;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageui.HomePageUI;
import pageui.ProductPageUI;

public class ProductPO extends BasePage {
    WebDriver driver;

    public ProductPO(WebDriver driver) {
        this.driver = driver;
    }


    public NewProductPO clickToCreateButton() {
        waitToElementClickable(driver, ProductPageUI.CREATE_BUTTON);
        clickToElement(driver, ProductPageUI.CREATE_BUTTON);
        return PageGeneratorManager.getNewProductPage(driver);
    }
}
