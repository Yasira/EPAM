package com.sw.ui.Starwars;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StarwarsFilmsPageTest extends CommonTest {
	
	StarWarsHomePageObjects homeObjects;
	StarwarsLibrary lib;
	StarwarsFilmsPageObjects filmObjects;
	
	/**
	 * 
	 * Valiodating Starwars Films Page
	 * Expected Result: User should be able to see Films listed on the Films page
	 * @param args
	 * @throws Exception
	 */
     
	 @Test(groups= {"FunctionalTest"})
	 public void verifyFilmsMenuOption()  throws Exception{
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
		 filmObjects=new StarwarsFilmsPageObjects(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
		 filmObjects.clickFilmsLink();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
				
		 assertTrue(lib.isElementDisplayed(filmObjects.FirstFilmLink),"First Film  is not shown");
		 assertTrue(lib.isElementDisplayed(filmObjects.SeeAllOption),"First Film  is not shown");
			
	 }
	
	 
	 /**
		 * 
		 * Valiodating Starwars Click on Film Link Option
		 * Expected Result: User should be able to see Films listed on the Films page
		 * @param args
		 * @throws Exception
		 */
	     
		 @Test(groups= {"FunctionalTest"})
		 public void verifyClickOnFilmsLinkTest()  throws Exception{
			 homeObjects=new StarWarsHomePageObjects(driver);
			 lib=new StarwarsLibrary(driver);
			 filmObjects=new StarwarsFilmsPageObjects(driver);
				
			 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
			 assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
			 filmObjects.clickFilmsLink();
			 assertTrue(lib.isElementDisplayed(filmObjects.FirstFilmLink),"First Film  is not shown");
			 //JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("window.scrollBy(0,1000)");
			
			 Actions actions = new Actions(driver);
			 actions.moveToElement(filmObjects.FirstFilmLink).click().perform();
			
			 
			 lib.waitForElementIsDisplayed(filmObjects.MoviewTitle,20);
				
			 assertTrue(lib.isElementDisplayed(filmObjects.MoviewTitle),"First Film title   is not shown");
			 assertTrue(lib.isElementDisplayed(filmObjects.BuyMovie),"First Film  Buy movie option is not shown");
			 assertTrue(lib.isElementDisplayed(filmObjects.ViewIMDB),"First Film  View IMDB is not shown");
			 assertTrue(lib.isElementDisplayed(filmObjects.ViewWookee),"First Film  view Wookeepedia is not shown");
						
			 assertTrue(lib.isElementDisplayed(filmObjects.Characters),"Characters option is not shown");
					
		 }
		 
		 /**
			 * 
			 * Valiodating Starwars Click on Film Link Option
			 * Expected Result: User should be able to see Films listed on the Films page
			 * @param args
			 * @throws Exception
			 */
		     
			 @Test(groups= {"FunctionalTest"})
			 public void verifyClickOnFilmsImageTest()  throws Exception{
				 homeObjects=new StarWarsHomePageObjects(driver);
				 lib=new StarwarsLibrary(driver);
				 filmObjects=new StarwarsFilmsPageObjects(driver);
					
				 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
				 assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
				 filmObjects.clickFilmsLink();
				 assertTrue(lib.isElementDisplayed(filmObjects.FirstFilmLink),"First Film  is not shown");
				 
				 //JavascriptExecutor js = (JavascriptExecutor) driver;
				 //js.executeScript("window.scrollBy(0,1000)");
				
				  Actions actions = new Actions(driver);
				  actions.moveToElement(filmObjects.FirstFilmImage).click().perform();
				  
				  lib.waitForElementIsDisplayed(filmObjects.MoviewTitle,20);
					
				 assertTrue(lib.isElementDisplayed(filmObjects.MoviewTitle),"First Film title   is not shown");
				 assertTrue(lib.isElementDisplayed(filmObjects.BuyMovie),"First Film  Buy movie option is not shown");
				 assertTrue(lib.isElementDisplayed(filmObjects.ViewIMDB),"First Film  View IMDB is not shown");
				 assertTrue(lib.isElementDisplayed(filmObjects.ViewWookee),"First Film  view Wookeepedia is not shown");
				 assertTrue(lib.isElementDisplayed(filmObjects.Characters),"Characters option is not shown");			
				 	
			 }
			 
			 
			 /**
				 * 
				 * Valiodating Starwars Click on Film Link Option
				 * Expected Result: User should be able to see Films listed on the Films page
				 * @param args
				 * @throws Exception
				 */
			     
				 @Test(groups= {"FunctionalTest"})
				 public void verifySeeAllOptionsFilmTest()  throws Exception{
					 homeObjects=new StarWarsHomePageObjects(driver);
					 lib=new StarwarsLibrary(driver);
					 filmObjects=new StarwarsFilmsPageObjects(driver);
						
					 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
					 assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
					 filmObjects.clickFilmsLink();
					 assertTrue(lib.isElementDisplayed(filmObjects.FirstFilmLink),"First Film  is not shown");
					 //JavascriptExecutor js = (JavascriptExecutor) driver;
					// js.executeScript("window.scrollBy(0,1000)");
					
					 (filmObjects.SeeAllOption).click();
					 Actions actions = new Actions(driver);
					 actions.moveToElement(filmObjects.SeeAllFirstFilm).click().perform();
					
					 
					 lib.waitForElementIsDisplayed(filmObjects.MoviewTitle,20);
						
					 assertTrue(lib.isElementDisplayed(filmObjects.MoviewTitle),"First Film title   is not shown");
					 assertTrue(lib.isElementDisplayed(filmObjects.BuyMovie),"First Film  Buy movie option is not shown");
					 assertTrue(lib.isElementDisplayed(filmObjects.ViewIMDB),"First Film  View IMDB is not shown");
					 assertTrue(lib.isElementDisplayed(filmObjects.ViewWookee),"First Film  view Wookeepedia is not shown");
								
					 assertTrue(lib.isElementDisplayed(filmObjects.Characters),"Characters option is not shown");
							
				 }
				 
				 
		/**
		 * 
		 * Verify FilmBuy Option using IMDB or Wookeepedia Options
		 * 
		 * 
		 * Expected	: User should taken to corresponding IMDB or Wookipedia link
		 * 
		 * 
		 */
		 @Test(groups= {"FunctionalTest"},dataProvider="BuyOption")
	     public void verifyFilmBuyOption(String args[])  throws Exception{
			 homeObjects=new StarWarsHomePageObjects(driver);
			 lib=new StarwarsLibrary(driver);
			 filmObjects=new StarwarsFilmsPageObjects(driver);
				
			 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
			 assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
			 filmObjects.clickFilmsLink();
			 assertTrue(lib.isElementDisplayed(filmObjects.FirstFilmLink),"First Film  is not shown");
				
			 Actions actions = new Actions(driver);
			 actions.moveToElement(filmObjects.FirstFilmImage).click().perform();
			  
			 lib.waitForElementIsDisplayed(filmObjects.MoviewTitle,20);
			 assertTrue(lib.isElementDisplayed(filmObjects.MoviewTitle),"First Film title   is not shown");
			 
			 String xpath=".//*[@id='ref-1-1']/div/div[2]/div[2]/div[2]/a[--num--]";
			 WebElement element= driver.findElement(By.xpath(xpath.replace("--num--", args[0])));
			 assertTrue(lib.isElementDisplayed(element)," Web element  not displayed");
			 element.click();
			 Thread.sleep(6000);
			 lib.switchWindowBasedOnPageSource(args[1], driver);
			 String currentUrl=driver.getCurrentUrl();
			 assertTrue(currentUrl.contains(args[2])," URL not as expected, Actual:"+currentUrl+"Expected"+args[2]);
			
					 
		 }
			
		 
		 @DataProvider(name="BuyOption")
		    public Object[][] getDataFromDataprovider(){
		    return new Object[][]
		    	{
		            { "1","IMDbPro","https://www.imdb.com/" },
		            { "2", "FANDOM","https://starwars.fandom.com" },
		           
		        };

		    }
			 
}
