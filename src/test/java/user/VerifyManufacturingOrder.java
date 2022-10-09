package user;

import common.BaseTest;
import common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.*;
import utilities.PropertiesFile;

public class VerifyManufacturingOrder extends BaseTest {
    WebDriver driver;
    LoginPO loginPage;
    HomePO homePage;
    InventoryPO inventoryPage;
    ProductPO productPage;
    NewProductPO newProductPage;
    ProductDetailPO productDetailPage;
    ManufacturingPO manufacturingPage;
    NewManufacturingPO newManufacturingPage;
    ManufacturingDetailPO manufacturingDetailPage;

    @BeforeClass
    public void init() {
        PropertiesFile.setPropertiesFile();
        driver = getBrowserDriver(PropertiesFile.getPropValue("browser"), PropertiesFile.getPropValue("url"));
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC_01_Verify_Manufacturing_Order_Successfully() {
        log.info("Verify_Manufacturing_Order_Successfully");

        log.info("Step 1: Input to email textbox : " + PropertiesFile.getPropValue("email"));
        loginPage.inputToEmailTextbox(PropertiesFile.getPropValue("email"));

        log.info("Step 2: Input to password textbox");
        loginPage.inputToPasswordTextbox(PropertiesFile.getPropValue("password"));

        log.info("Step 3: Click to login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Step 4: Click to inventory menu");
        inventoryPage = homePage.clickToInventoryMenu();

        log.info("Step 5: Click to products top menu");
        inventoryPage.clickToProductsTopMenu();

        log.info("Step 6: Select products item");
        productPage = inventoryPage.clickToProductsItem();

        log.info("Step 7: Click to create button");
        newProductPage = productPage.clickToCreateButton();


        String productName = PropertiesFile.getPropValue("prefixProduct") + getRandomNumber();
        log.info("Step 8: Input product name: "+productName);
        newProductPage.inputToProductName(productName);

        log.info("Save product name: " + productName);
        GlobalConstants.currentProductName = productName;

        log.info("Step 9: Update quantity product : " + PropertiesFile.getPropValue("quantityProduct"));
        newProductPage.updateQuantityProductWithValue(PropertiesFile.getPropValue("quantityProduct"));

        log.info("Step 10: Click to save button");
        productDetailPage = newProductPage.clickToSaveButton();

        log.info("Save product quantity: " + productDetailPage.getProductQuantity());
        GlobalConstants.currentProductQuantity = productDetailPage.getProductQuantity();

        log.info("Step 11: Click to home menu");
        homePage = productDetailPage.clickToHomeMenu();

        log.info("Step 12: Click to manufacturing menu");
        manufacturingPage = homePage.clickToManufacturingMenu();

        log.info("Step 13: Click to create button");
        newManufacturingPage = manufacturingPage.clickToCreateButton();

        log.info("Step 14: Input product name: " + GlobalConstants.currentProductName);
        newManufacturingPage.inputToProductNameField(GlobalConstants.currentProductName);

        log.info("Step 15: Click to save button");
        manufacturingDetailPage = newManufacturingPage.clickToSaveButton();

        log.info("Save manufacturing order name");
        GlobalConstants.currentManufacturingOrderName = manufacturingDetailPage.getManufacturingOrderName();

        log.info("Save manufacturing quantity sale");
        GlobalConstants.currentManufacturingOrderQuantitySale = manufacturingDetailPage.getManufacturingOrderQuantitySale();

        log.info("Step 16: Click to confirm button");
        manufacturingDetailPage.clickToConfirmButton();

        log.info("Step 17: Click to mark as done button");
        manufacturingDetailPage.clickToMarkAsDoneButton();

        log.info("Step 18: Click to ok button on confirm pop-up");
        manufacturingDetailPage.clickToConfirmOkButton();

        log.info("Step 19: Click to apply button on confirm pop-up");
        manufacturingDetailPage.clickToConfirmApplyButton();

        log.info("Step 20: Verify manufacturing name is: " + GlobalConstants.currentManufacturingOrderName);
        Assert.assertEquals(manufacturingDetailPage.getManufacturingOrderName(), GlobalConstants.currentManufacturingOrderName);

        log.info("Step 21: Verify product name is: " + GlobalConstants.currentProductName);
        Assert.assertEquals(manufacturingDetailPage.getProductName(), GlobalConstants.currentProductName);

        log.info("Step 22: Verify product quantity is: " + GlobalConstants.currentProductQuantity);
        Assert.assertEquals(manufacturingDetailPage.getProductQuantity(), GlobalConstants.currentProductQuantity);

        log.info("Step 23: Verify manufacturing order status is " + GlobalConstants.currentManufacturingOrderStatus + " is displayed");
        Assert.assertTrue(manufacturingDetailPage.isManufacturingOrderDone());

        log.info("Step 24: Click to manufacturing menu");
        manufacturingPage = manufacturingDetailPage.clickToManufacturingMenu();

        log.info("Step 25: Click to close manufacturing order icon");
        manufacturingPage.clickToManufacturingOrderCloseIcon();

        log.info("Step 26: Input to search field: " + GlobalConstants.currentManufacturingOrderName);
        manufacturingPage.inputToSearchField(GlobalConstants.currentManufacturingOrderName);

        log.info("Step 27: Verify manufacturing order name displayed correctly after searching");
        Assert.assertEquals(manufacturingPage.getManufacturingOrderName(), GlobalConstants.currentManufacturingOrderName);

        log.info("Step 28: Verify product name displayed correctly after searching");
        Assert.assertEquals(manufacturingPage.getProductName(), GlobalConstants.currentProductName);

        log.info("Step 29: Verify total quantity displayed correctly after searching");
        Assert.assertEquals(manufacturingPage.getTotalQuantity(), GlobalConstants.currentProductQuantity);

        log.info("Step 30: Verify manufacturing quantity displayed correctly after searching");
        Assert.assertEquals(manufacturingPage.getManufacturingOrderQuantitySale(), GlobalConstants.currentManufacturingOrderQuantitySale);

        log.info("Step 31: Verify manufacturing order status is done after searching");
        Assert.assertEquals(manufacturingPage.getManufacturingOrderStatus(), GlobalConstants.currentManufacturingOrderStatus);
    }

    @AfterClass
    public void closeBrowser() {

        closeBrowserAndDriver(driver);
    }

}
