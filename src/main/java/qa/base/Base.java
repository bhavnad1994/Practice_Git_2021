package qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	static public WebDriver driver;
	static public  Properties prop;
	
	
	public Base() {
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D:\\SeleniumGITDemo\\src\\main\\java\\com\\utility\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
		
		
		public void initializaton() {
			String browserName=prop.getProperty("Browser");
			
			if ( browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeProperty"));
				driver=new ChromeDriver();
			}
			
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			
			
		}
	}


