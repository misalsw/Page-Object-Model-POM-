package com.crm.base;

import com.crm.utilities.TestUtil;
import com.crm.utilities.WebEventListner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties props;
    public static EventFiringWebDriver e_driver;
    public static WebEventListner eventListner;
    static Logger log = Logger.getLogger(TestBase.class);


    public TestBase() {

        props = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("src/main/java/com/crm/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            props.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = props.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Custom Program\\Selenium Java\\Selenium__Java\\src\\Driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListner = new WebEventListner();
        e_driver.register(eventListner);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT));
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT, TimeUnit.SECONDS);
        driver.get(props.getProperty("url"));

    }
}
