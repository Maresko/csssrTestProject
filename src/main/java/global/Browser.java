package global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private WebDriver driver;

    public Browser(String browserName){
        String baseDir = System.getProperty("user.dir");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", baseDir + "/src/main/resources/Drivers/chromedriver_macos");
            driver = new ChromeDriver();
        }
    }

    public static Browser browser;
}
