package pageobject;

import common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageui.NewProductPageUI;

public class NewProductPO extends BasePage {
    WebDriver driver;

    public NewProductPO(WebDriver driver) {
        this.driver = driver;
    }


    public void inputToProductName(String productName) {
        waitToElementClickable(driver, NewProductPageUI.PRODUCT_NAME_INPUT);
        sendkeyToElement(driver, NewProductPageUI.PRODUCT_NAME_INPUT,productName);
    }


    public void updateQuantityProductWithValue(String quantityProduct) {
        waitToElementClickable(driver, NewProductPageUI.QUANTITY_PRODUCT_INPUT);
        waitToElementVisible(driver, NewProductPageUI.QUANTITY_PRODUCT_INPUT);
        sleepInSecond(3);
        clearElementTextByKeyboard(driver, NewProductPageUI.QUANTITY_PRODUCT_INPUT);
        sendkeyToElement(driver, NewProductPageUI.QUANTITY_PRODUCT_INPUT, quantityProduct.toString());
        sendKeyBoardToElement(driver, NewProductPageUI.QUANTITY_PRODUCT_INPUT,Keys.ENTER);
    }

    public ProductDetailPO clickToSaveButton() {
        waitToElementClickable(driver, NewProductPageUI.SAVE_BUTTON);
        clickToElement(driver, NewProductPageUI.SAVE_BUTTON);
        return PageGeneratorManager.getProductDetailPage(driver);
    }


}
