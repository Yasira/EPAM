package com.sw.ui.Starwars;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StarwarsHomePageValidationTest extends CommonTest{
	
	StarWarsHomePageObjects homeObjects;
	StarwarsLibrary lib;
	  
	/**
	 * 
	 * Valiodating Starwars Social Pages
	 * @param args
	 * @throws Exception
	 */
     
	 @Test(groups= {"FunctionalTest"}, dataProvider="SocialPage")
	 public void verifyStarwarsSocialPage(String args[])  throws Exception{
		 StarWarsHomePageObjects homeObjects=new StarWarsHomePageObjects(driver);
		 StarwarsLibrary lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
			
		 String xpath=".//*[@id='social-links']/li[--num--]/a";
		 WebElement element= driver.findElement(By.xpath(xpath.replace("--num--", args[0])));
		 assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
		 assertTrue(lib.isElementDisplayed(element)," Web element  not displayed");
		 element.click();
		 Thread.sleep(6000);
		 lib.switchWindowBasedOnPageSource(args[1], driver);
		 String currentUrl=driver.getCurrentUrl();
		 assertTrue(currentUrl.contains(args[2])," URL not as expected, Actual:"+currentUrl+"Expected"+args[2]);
			
	 }
	
	 /**
	  * Validating STarwars Home Menu Options
	  * @throws Exception
	  */
	 @Test(groups= {"FunctionalTest"})
	 public void validateHomePageMenuOptions() throws Exception{
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 assertTrue(lib.isElementDisplayed(homeObjects.CommunityLink)," Communty Link not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.CommunityLogo)," Community Logo not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.DataBankLink)," DataBank  not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.DataBankLogo)," DataBank Logo not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.EventsLink)," Events  not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.EventsLogo)," Events Logo not displayed");
		
		 assertTrue(lib.isElementDisplayed(homeObjects.FilmsLink)," Films Link not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.FilmsLogo)," FIlms Logo not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.GamesLink)," Games Link not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.GamesLogo)," Games Logo not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.VideoLink)," Video Link not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.VideoLogo)," VIdeo Logo not displayed");
		
		 assertTrue(lib.isElementDisplayed(homeObjects.TVShowsLink)," TV Shows link  not displayed");
		 assertTrue(lib.isElementDisplayed(homeObjects.TVShowsLogo)," TV Shows Logo not displayed");
		
		 
	 }
	 
	 /**
	  * Validating  Starwars Search field
	  * @throws Exception
	  */
		
	 @Test(groups= {"FunctionalTest"})
	 public void validateSearchFieldTest() throws Exception{
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 homeObjects.setSearchStarWars("Star wars");
		 assertTrue(homeObjects.getSearchResult(),"Search result not displayed");
	 }
	 
	 
	 /**
	  * Validating  ShowDisney Option
	  * @throws Exception
	  */
		
	 @Test(groups= {"FunctionalTest"})
	 public void validateShowAndHideDisneyOption() throws Exception{
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 homeObjects.clickShowDisney();
		 assertTrue(lib.isElementDisplayed(homeObjects.DisneyLogo),"Disney Logo is not shown");
		 assertTrue(lib.isElementDisplayed(homeObjects.HideDisney),"Hide Disney option is not shown");
		 homeObjects.HideDisney.click();
		 assertTrue(lib.isElementDisplayed(homeObjects.ShowDisney),"Show Disney Logo is not shown");
			
	 }
	
	 @DataProvider(name="SocialPage")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][]
	    	{
	            { "1","Forgot account","https://www.facebook.com/StarWars" },
	            { "2", "Follow starwars","https://starwars.tumblr.com" },
	            { "3", "Have an account?","https://twitter.com/starwars" },
	            { "4","Log In to Instagram","https://www.instagram.com/starwars" },
	            { "5", "Join google+","https://plus.google.com/+StarWars" },
	            { "6", "Get YouTube Premium ","https://www.youtube.com/user/starwars" }
	        };

	    }
}
