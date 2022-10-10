package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    protected WebElement getElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    protected WebElement getElement(WebDriver driver, String locator, String... values) {
        return getElement(driver, getDynamicLocator(locator, values));
    }

    public List <WebElement> getElements(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    protected void clickToElement(WebDriver driver, String locatorType) {
        element = getElement(driver, locatorType);
        if(driver.toString().toLowerCase().contains("internet explorer"))
        {
            clickToElementByJS(driver, locatorType);
            sleepInSecond(3);
        }
        else
        {
            element.click();

        }

    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("//")) {
            by = By.xpath(locatorType);
        }  else if (locatorType.startsWith("(")) {
            by = By.xpath(locatorType);
        }
        else {
            throw new RuntimeException("Locator type is not supported");
        }
        return by;
    }

    protected void sendkeyToElement(WebDriver driver, String locatorType, String value) {
        element = getElement(driver, locatorType);
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    protected String getDynamicLocator(String locatorType, String... values) {
        locatorType = String.format(locatorType, (Object[]) values);
        return locatorType;
    }

    protected void sleepInSecond(long second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected String getElementText(WebDriver driver, String locatorType) {
        element = getElement(driver, locatorType);
        return element.getText();
    }

    protected boolean isElementDisplayed(WebDriver driver, String locatorType) {
        return getElement(driver, locatorType).isDisplayed();
    }

    protected void sendKeyBoardToElement(WebDriver driver, String locatorType, Keys key) {
        action = new Actions(driver);
        action.sendKeys(getElement(driver, locatorType), key).perform();
    }

    protected void clickToElementByJS(WebDriver driver, String locatorType) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElement(driver, locatorType);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    protected void waitToElementVisible(WebDriver driver, String locatorType) {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIME));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));

    }

    protected void waitToElementClickable(WebDriver driver, String locatorType) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIME));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    protected void overrideImplicitWait(WebDriver driver, long timeSecond)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    protected void clearElementTextByKeyboard(WebDriver driver,String locator)
    {
        String cssLocator = locatorWithoutPrefixCSS(locator);
        jsExecutor = (JavascriptExecutor) driver;
        String value = (String) jsExecutor.executeScript("return document.querySelector(" + '"' + cssLocator + '"' + ").value");
        int sizeText = value.length();
        Actions actions = new Actions(driver);

        for(int i = 0;i<sizeText;i++)
        {
            actions.sendKeys(driver.findElement(By.cssSelector(cssLocator)),Keys.BACK_SPACE).perform();
        }
    }

    protected String locatorWithoutPrefixCSS(String locator)
    {
        return locator.substring(4);
    }

    private WebDriverWait explicitWait;
    private WebElement element;
    private JavascriptExecutor jsExecutor;
    private Actions action;

}
