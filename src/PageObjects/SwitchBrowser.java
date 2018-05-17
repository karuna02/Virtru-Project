package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchBrowser {
	
	public static WebDriver driver;
	
	public SwitchBrowser(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver SecureVirtru()
	{
	
		Set<String>ids = driver.getWindowHandles();
		Iterator<String>it = ids.iterator();
		String window1 = it.next();
		String window2 = it.next();
		driver.switchTo().window(window2);
		return driver;
	}
	
	By UserEmail = By.className("userEmail");
	By Login = By.className("oauth-provider-google");
	
	public WebElement userEmail()
	{
		return driver.findElement(UserEmail);
	}
	
	public WebElement login()
	{
		return driver.findElement(Login);
	}
	

}
