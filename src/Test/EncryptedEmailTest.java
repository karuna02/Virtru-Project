package Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.EmailVerification;
import PageObjects.LoginPage;
import PageObjects.SwitchBrowser;
import resources.EncryptPassword;
import resources.EncryptedEmailBase;



public class EncryptedEmailTest extends EncryptedEmailBase {
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver=InitializeDriver();

	}
	@SuppressWarnings("deprecation")
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		// creating object to that class and invoke methods of it
		LoginPage login = new LoginPage(driver);
		EncryptPassword pass = new EncryptPassword();
		
	    String mailPass = new String (Base64.decodeBase64(pass.MailPassword()));
	    		
		login.email().sendKeys(Username);
		login.next().click();
		login.password().sendKeys(mailPass);
		login.signIn().click();	
		
		EmailVerification email = new EmailVerification(driver);
		
		email.email().click();
		email.link().click();
		
		SwitchBrowser browser = new SwitchBrowser(driver);
		
		browser.SecureVirtru();
		browser.userEmail().click();
		browser.login().click();
		
		
				
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String EmailText = String.valueOf(wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//*[@id='tdf-body']/div"), "Test Email")));
		
		Assert.assertTrue(true, EmailText);		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.quit();
		driver=null;
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]="karunasagar0118@gmail.com";		
		
		return data;		
		
	}


}
