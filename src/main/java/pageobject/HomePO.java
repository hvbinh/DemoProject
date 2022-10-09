package pageobject;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageui.HomePageUI;
import pageui.InventoryPageUI;
import pageui.LoginPageUI;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }


    public InventoryPO clickToInventoryMenu() {
        waitToElementClickable(driver, HomePageUI.INVENTORY_MENU);
        clickToElement(driver, HomePageUI.INVENTORY_MENU);
        return PageGeneratorManager.getInventoryPage(driver);
    }

    public ManufacturingPO clickToManufacturingMenu() {
        waitToElementClickable(driver, HomePageUI.MANUFACTURING_MENU);
        clickToElement(driver, HomePageUI.MANUFACTURING_MENU);
        return PageGeneratorManager.getManufacturingPage(driver);
    }
}
