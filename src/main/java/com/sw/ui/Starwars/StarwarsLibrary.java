package com.sw.ui.Starwars;

import java.util.HashSet;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StarwarsLibrary {
	
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
				
				else {System.out.println("Unable to find element"+element);}
			} catch (NoSuchElementException e) {
				e.getMessage();
				
			} catch (Exception e) {
				e.getMessage();
			}
			return false;
		}
	  
	  public  void switchWindowBasedOnPageSource(String somePageSourceContent,WebDriver driver) throws Exception{
			HashSet<String> availableWindows = (HashSet<String>) driver.getWindowHandles(); 
			for(String window : availableWindows){
				driver.switchTo().window(window);
				if(driver.getPageSource().contains(somePageSourceContent)){
					System.out.println("url"+driver.getCurrentUrl());
					break;
				}
			}
		}
	 
}
