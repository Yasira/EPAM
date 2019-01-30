package com.sw.ui.Starwars;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTest {
	
	  public WebDriver driver;
	  private Properties properties = new Properties();
	  
	 
	  @BeforeMethod(groups = { "commonTest"})
	    public void setUp() throws Exception {
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
	        driver = new ChromeDriver();
	        properties.load(new FileReader(new File(System.getProperty("user.dir")+"\\configdata\\config.properties")));
	        driver.get(properties.getProperty("URL"));

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        
	        
	        
	       
	    }
	  
	  @AfterMethod(groups = { "commonTest"})
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

}
