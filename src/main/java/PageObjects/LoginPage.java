package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;*/
import org.openqa.selenium.WebElement;

import Utils.BrowserSelector;

public class LoginPage {
	
	WebDriver driver;
	By username_txtbox = By.xpath("//input[@name='userName']");
	By password_txtbox = By.xpath("//input[@name='password']");
	By submit_btn =  By.xpath("//input[@type='submit']");
	By login_successmessage = By.xpath("//h3[text()='Login Successfully']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String uname) {
		driver.findElement(username_txtbox).sendKeys(uname);
	}
	public void setPassword(String password) {
		driver.findElement(password_txtbox).sendKeys(password);
	}
	public void clickLoginButton() {
		WebElement logbutton = driver.findElement(submit_btn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", logbutton);
	}
	public String getLoginMessage() {
		String actualLoginMessage = driver.findElement(login_successmessage).getText();
		return actualLoginMessage;
	}
	
	public String getTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	
	
	/*public WebDriver driver;
	BrowserSelector bs = new BrowserSelector();
	
	public LoginPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="userName")
	WebElement usrname_txtbox;
	
	@FindBy(name="password")
	WebElement password_txtbox;
	
	@FindBy(name="submit")
	WebElement submit_btn;
	
	@FindBy(xpath="//h3[text()='Login Successfully']")
	WebElement login_successmessage;
	
	public void setUserName(String username){
		//driver=bs.selectBrowser();
		usrname_txtbox.sendKeys(username);
	}
	
	public void setPassword(String password) {
		password_txtbox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		submit_btn.click();
	}

	public String getLoginMessage() {
		String actualLoginMessage = login_successmessage.getText();
		return actualLoginMessage;
	}*/
	
	
}
