package com.sw.ui.Starwars;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;

import org.apache.log4j.Logger;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.By;

public class StarwarsLibrary {
	
	private static final Logger log = Logger.getLogger(StarwarsLibrary.class);
	
	WebDriver driver;
	
	public StarwarsLibrary(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Wait for element displayed
	 * @param element
	 * @param timeOutInSeconds
	 * @throws Exception
	 */
	 public  void waitForElementIsDisplayed(WebElement element, long timeOutInSeconds) throws Exception {
				WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
				wait.until(ExpectedConditions.visibilityOf(element));
				log.info("Waiting for the element to displayed");

	 }
	 
	 /**
	  * check for element displayed
	  * @param element
	  * @return
	  * @throws Exception
	  */
	  public boolean isElementDisplayed(WebElement element) throws Exception {
			try {
				if (element.isDisplayed()) {
					return true;
				} 
				
				else {log.info("Unable to find element"+element);}
			} catch (NoSuchElementException e) {
				e.getMessage();
				
			} catch (Exception e) {
				e.getMessage();
			}
			return false;
		}
	  
	  /**
	   * Switch to new window based on Page source
	   * @param somePageSourceContent
	   * @param driver
	   * @throws Exception
	   */
	  public  void switchWindowBasedOnPageSource(String somePageSourceContent,WebDriver driver) throws Exception{
			HashSet<String> availableWindows = (HashSet<String>) driver.getWindowHandles(); 
			for(String window : availableWindows){
				driver.switchTo().window(window);
				if(driver.getPageSource().contains(somePageSourceContent)){
					log.info("url"+driver.getCurrentUrl());
					break;
				}
			}
		}
	 
	  /**
	   * Read data from properties file
	   * @param file_name
	   * @param key
	   * @return
	   * @throws IOException
	   */
	  public static String readPropertiesFile(String file_name, String key) throws IOException{
			log.info("file name is "+file_name);
			
			try{
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream(file_name);
			prop.load(fs);
			String value = prop.get(key).toString();
			
			//log.info("value is "+value);
			return value;
			}
			catch(FileNotFoundException e){
				
				return null;
			}
	  }
	  
	  /**
		 *  Implementation of mouse over.
		 *  Accepts the webElement at parameter and performs mouseOver action on that particular Element.
		 *  @throws Exception
		 *  
		 *  
		 */
		public void mouseOver(WebElement element) throws Exception{

			log.info("Enter MouseOver() Method");
			Actions builder = new Actions(driver);
			Action mouseOver = builder.moveToElement(element).build();
			mouseOver.perform();
			log.info("Exit mouseOver() Method");
		}
}
