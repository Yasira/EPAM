package com.sw.ui.Starwars;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTest {
	private static final Logger log = Logger.getLogger(CommonTest.class);
	
	  public WebDriver driver;
	  private Properties properties = new Properties();
	  StarwarsLibrary lib;
	 
	  @BeforeMethod(groups = { "commonTest"})
	    public void setUp(Method method) throws Exception {
		   lib=new StarwarsLibrary(driver);
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
	        driver = new ChromeDriver();
	        properties.load(new FileReader(new File(System.getProperty("user.dir")+"\\configdata\\config.properties")));
	        driver.get(properties.getProperty("URL"));

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        
	        Properties log4jProperties;
	        log4jProperties =new Properties();
			try{
				
			log4jProperties.load(new FileInputStream(System.getProperty("user.dir")+"\\configdata\\log4j.properties"));
			}
			catch (IOException e) {
				log.info(e.getMessage());
			System.err.println("log4j Properties File\"log4j.properties\" not found in current directory..Exiting..");
			System.exit(-1);
			}

	        
	        log4jProperties.setProperty("log4j.appender.file.File","Logs//"+method.getName()+".log");
			//Error file rewriting with time stamp
			log4jProperties.setProperty("log4j.appender.error.file","Logs//ErrorLogOf"+method.getName()+".log");
			PropertyConfigurator.configure(log4jProperties);
			log.debug("before method");
			log.info("checking before class execution for generating log file");
			
	       
	    }
	  
	  	@AfterMethod(groups = { "commonTest"},dependsOnMethods={"takeScreenShot"})
	    public void tearDown() throws Exception {
	  		 log.info(" After method ");
	        driver.quit();
	        log.info("quit the driver");
	    }
	  	
	  	/**
	  	 * 
	  	 * Adding screenshot method, Screenshot will be taken for failed testcases
	  	 * @param m
	  	 * @param result
	  	 * @throws Exception
	  	 */
	  	
	  	@AfterMethod(groups = { "commonTest" })
		  public void takeScreenShot(Method m , ITestResult result)throws Exception {
		 //getStatus of ITestResult returns 2 if the testcases is failed	 
		  if (result.getStatus() == 2) {
		   new File("./output/screenshot").mkdirs(); 
	       File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	       String screenshotFileName="./output/screenshot/"+m.getName()+"_"+m.getDeclaringClass().getName() + ".png";
	       try {
	           FileUtils.copyFile(screenShot, new File(screenshotFileName));
	           System.out.println("Screenshot of the failed testcases has taken copied to the output file");
	      	 result.setAttribute("screenshotFile", screenshotFileName);
	      	 
	      	 
	      	final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	      	System.setProperty(ESCAPE_PROPERTY, "false");

	      	String fileName = System.getProperty("user.dir") +File.separator + "output" + File.separator + "screenshot" + File.separator + m.getName()+"_"+m.getDeclaringClass().getName() + ".png";
	      	Reporter.setCurrentTestResult(result);
	      	Reporter.log("<a href=\""+fileName+"\"> Screenshot </a>");
	      	//Reporter.log("<img src=\"file:///" + fileName + "\" alt=\"\"/><br/>");
	      	
	       } catch (Exception ioe) {
	           throw new RuntimeException(ioe.getMessage(), ioe);
	       }
			 }
		}
}
