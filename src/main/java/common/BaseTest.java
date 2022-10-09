package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    private String projectFolder = System.getProperty("user.dir");
    private String osName = System.getProperty("os.name");
    protected final Log log;

    public BaseTest() {
        log = LogFactory.getLog(getClass());
    }



    protected synchronized WebDriver getBrowserDriver(String browserName, String url) {
        // setBrowserDriver();
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        if (browser == Browser.CHROME_UI) {
            WebDriverManager.chromedriver().setup(); // .driverVersion("86.0.4240.22").setup();
            driver = new ChromeDriver();
        } else if (browser == Browser.FIREFOX_UI) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser == Browser.EDGE_CHROMIUM) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser == Browser.CHROME_HEADLESS) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browser == Browser.FIREFOX_HEADLESS) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else {
            throw new RuntimeException("please input valid browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.SHORT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GlobalConstants.LONG_TIME));

        driver.get(url);

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void closeBrowserAndDriver(WebDriver driver) {
        try {

            String osName = System.getProperty("os.name").toLowerCase();


            String cmd = "";
            if (driver != null) {
                driver.quit();
            }

            // Quit driver executable file in Task Manager
            if (driver.toString().toLowerCase().contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if (osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("edge")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill msedgedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();


        } catch (Exception e) {
            System.out.println("close browser failed " + e.toString());
        }
    }
    protected int getRandomNumber()
    {
        Random random = new Random();
        return random.nextInt(999999);
    }


}
