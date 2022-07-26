package Insider_Task.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver(){

    }

    private static WebDriver driver;


    public static WebDriver getDriver(){
        if(driver==null){

            String browserType = ConfigurationReader.get("browser");
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);
                    driver= new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }

    }


}
