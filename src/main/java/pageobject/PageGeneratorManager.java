package pageobject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPO getLoginPage(WebDriver driver)
    {
        return new LoginPO(driver);
    }
    public static HomePO getHomePage(WebDriver driver)
    {
        return new HomePO(driver);
    }
    public static InventoryPO getInventoryPage(WebDriver driver)
    {
        return new InventoryPO(driver);
    }
    public static ProductPO getProductPage(WebDriver driver)
    {
        return new ProductPO(driver);
    }
    public static NewProductPO getNewProductPage(WebDriver driver)
    {
        return new NewProductPO(driver);
    }
    public static ProductDetailPO getProductDetailPage(WebDriver driver)
    {
        return new ProductDetailPO(driver);
    }
    public static ManufacturingPO getManufacturingPage(WebDriver driver)
    {
        return new ManufacturingPO(driver);
    }
    public static NewManufacturingPO getNewManufacturingPage(WebDriver driver)
    {
        return new NewManufacturingPO(driver);
    }
    public static ManufacturingDetailPO getManufacturingDetailPage(WebDriver driver)
    {
        return new ManufacturingDetailPO(driver);
    }
}
