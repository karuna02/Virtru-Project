package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EncryptedEmailBase {
	
	public static WebDriver driver;
	public static DesiredCapabilities capabilities;
	public static Properties prop;
		
	@SuppressWarnings("deprecation")
	public WebDriver InitializeDriver() throws IOException
	{
		prop = new Properties();	
		FileInputStream fis = new FileInputStream("C:\\Users\\kchin_000\\Documents\\WorkSpace\\SeleniumTesting1\\Data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
					
			//options.addExtensions(new File("C:\\karuna\\7.4.3.0_0.crx"));
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchin_000\\chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			driver = new ChromeDriver(capabilities);
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\kchin_000\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;		
	}	


}
