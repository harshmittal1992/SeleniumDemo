package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSelector {

   public static WebDriver driver = null;
   public static Properties prop = new Properties();
	
	 public WebDriver selectBrowser() throws Exception {

         FileInputStream fis = null;
         File configfile = new File("./config.properties");
         fis = new FileInputStream(configfile);
         //Properties prop = new Properties();
         prop.load(fis); 
         // WebDriver driver = null;
         String browser = prop.getProperty("browser");
         while (browser == null) {
             System.out.println("Browser is not specified in Configuration file. Terminating process !!!");
             System.exit(0);
         }
         if (browser.equalsIgnoreCase("chrome")) {
        	 WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
             System.out.println("Browser selected for testing is :  Google Chrome");
         } else if (browser.equalsIgnoreCase("ie")) {
        	 //WebDriverManager.iedriver().setup();
        	 System.setProperty("webdriver.ie.driver", "D:\\IEDriver\\\\IEDriverServer.exe");
             driver = new InternetExplorerDriver();
         System.out.println("Browser selected for testing is :  Internet Explorer");
         
         }else {
        	 System.out.println("Selected browser value not available --> Update in Configuration file is required");
             System.exit(0);
         }
         return driver;
}
}
