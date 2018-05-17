package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By Email = By.id("identifierId");
	By Next = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/content/span");
	By password = By.name("password");
	By sigin = By.xpath("//*[@id='passwordNext']/content/span");





public LoginPage(WebDriver driver) {
	
	this.driver=driver;
}

public WebElement email()
{
	return driver.findElement(Email);	
}

public WebElement next()
{
	return driver.findElement(Next);	
}

public WebElement password()
{
	return driver.findElement(password);
}

public WebElement signIn()
{
	return driver.findElement(sigin);
}

}
