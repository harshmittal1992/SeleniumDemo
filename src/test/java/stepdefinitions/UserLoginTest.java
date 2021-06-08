package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageobjects.LoginPage;
import utils.BrowserSelector;
import utils.ReadExcelData;

public class UserLoginTest extends BrowserSelector {
	LoginPage loginPg = new LoginPage(driver);

	@Given("user is on the log in page")
	public void user_is_on_the_log_in_page() throws Exception {
		System.out.println("Title of the page is" + " " + loginPg.getTitle());
		Assert.assertEquals(
				ReadExcelData.getExcelDataAsMap(prop.getProperty("datafilename"), prop.getProperty("testdatasheet"))
						.get("expectedtitle"),
				loginPg.getTitle());
	}

	@When("User enters valid user name in username field")
	public void user_enters_valid_user_name_in_username_field() throws IOException {
		loginPg.setUserName(
				ReadExcelData.getExcelDataAsMap(prop.getProperty("datafilename"), prop.getProperty("testdatasheet"))
						.get("username"));
		// ReadExcelData.getExcelDataAsMap("userlogintesdata",
		// "userloginsheet").get("username");
	}

	@When("User enters valid passoword")
	public void user_enters_valid_passoword() throws IOException {
		loginPg.setPassword(
				ReadExcelData.getExcelDataAsMap(prop.getProperty("datafilename"), prop.getProperty("testdatasheet"))
						.get("password"));
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		loginPg.clickLoginButton();
	}

	@Then("login success message is displayed")
	public void login_success_message_is_displayed() throws IOException {
		System.out.println("Message displayed after user login:" + " " + loginPg.getLoginMessage());
		Assert.assertEquals(
				ReadExcelData.getExcelDataAsMap(prop.getProperty("datafilename"), prop.getProperty("testdatasheet"))
						.get("expectedloginmessage"),
				loginPg.getLoginMessage());
	}

}
