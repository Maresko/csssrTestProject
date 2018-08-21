package global;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Drivers {


    private static WebDriver driver = null;
    String baseDir = System.getProperty("user.dir");

    public WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", baseDir + driverDetect());

        Configuration.timeout = 30000;
        Configuration.collectionsTimeout = 30000;

        return driver = new ChromeDriver();
    }

    public WebDriver getChromeDriverMobile(){

        System.setProperty("webdriver.chrome.driver", baseDir + driverDetect());
        String ios6ua = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5376e Safari/8536.25";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-agent=" + ios6ua);
        chromeOptions.addArguments("--window-size=100,700");

        Configuration.timeout = 30000;
        Configuration.collectionsTimeout = 30000;

        return driver = new ChromeDriver(chromeOptions);
    }

    private static String driverDetect(){
        String macOSDriver = "/src/main/resources/Drivers/chromedriver";
        String winDriver = "/src/main/resources/Drivers/chromedriver.exe";
        String linuxDriver = "/src/main/resources/Drivers/chromedriver_linux";

        String strOSName = System.getProperty("os.name");

        if (strOSName.toLowerCase().contains("win"))
            return winDriver;
        else if (strOSName.toLowerCase().contains("mac"))
            return macOSDriver;
        else
            return linuxDriver;
    }
}
