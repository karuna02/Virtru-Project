package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailVerification {

	
	public WebDriver driver;
	
	//By Skip1 = By.className("virtru-tutorial-popover-x-button");	
	By Email = By.className("bog");
	By UnlockMessage = By.linkText("Unlock Message");
		
	public EmailVerification(WebDriver driver) {
		this.driver = driver;
	}
	
	/*public WebElement skip()
	{
		
		return driver.findElement(Skip1);
		
	}*/

	public WebElement email()
	{
		
		return driver.findElement(Email);
		
	}
	
	public WebElement link()
	{
		
		return driver.findElement(UnlockMessage);
		
	}	
	
}
