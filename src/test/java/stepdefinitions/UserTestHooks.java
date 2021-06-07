package stepdefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.BrowserSelector;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class UserTestHooks extends BrowserSelector {

	//public WebDriver driver = null;
	BrowserSelector bs;

	@Before("@userlogin")
	public void SetBrowserAndUrl() throws Exception {
		System.out.println("*************Before Scenario***********");
		bs = new BrowserSelector();
		driver = bs.selectBrowser();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	@After(order=1)
	public void takeScreenshotOnFailure(Scenario scenario) {
		
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "attachedfailedscreenshot");
		}
	}
	@After(order=0)
	public void afterScenario() {
		System.out.println("############After Scenario##########");
		driver.close();
	}
	 
}
