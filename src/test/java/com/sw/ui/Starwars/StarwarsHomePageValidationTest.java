package com.sw.ui.Starwars;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StarwarsHomePageValidationTest extends CommonTest{
	
	private static final Logger log = Logger.getLogger(StarwarsHomePageValidationTest.class);
	
	StarWarsHomePageObjects homeObjects;
	StarwarsLibrary lib;
	  
	/**
	 * 
	 * Validating Starwars Social Pages
	 * 
	 * Expected: Each Social page should be navigate to corresponding Starwars Social Page
	 * @param args
	 * @throws Exception
	 */
     
	 @Test(groups= {"FunctionalTest"}, dataProvider="SocialPage")
	 public void verifyStarwarsSocialPage(String args[])  throws Exception{
		 StarWarsHomePageObjects homeObjects=new StarWarsHomePageObjects(driver);
		 StarwarsLibrary lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 log.info("Logged in to Starwars Page Successfully");
			
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
	  * 
	  * Expected: All the menu options and Icon should be validated
	  * @throws Exception
	  */
	 @Test(groups= {"FunctionalTest"})
	 public void validateHomePageMenuOptions() throws Exception{
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 log.info("Logged in to Starwars Page Successfully");
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
	  * 
	  * Expected: User should be able to search with valid data and result should be shown
	  * @throws Exception
	  */
		
	 @Test(groups= {"FunctionalTest"})
	 public void validateSearchFieldTest() throws Exception{
		 log.info("Logged in to Starwars Page Successfully");
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 homeObjects.setSearchStarWars("Star wars");
		 assertTrue(homeObjects.getSearchResult(),"Search result not displayed");
	 }
	 
	 /**
	  * Validating  Starwars Search field with Invalid data
	  *  No result for the data message should be shown
	  * @throws Exception
	  */
		
	 @Test(groups= {"FunctionalTest"})
	 public void validateSearchFieldTestWithInvalidWord() throws Exception{
		 log.info("Logged in to Starwars Page Successfully");
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 homeObjects.setSearchStarWars("!@#");
		 assertTrue((homeObjects.getSearchResultWithInvalid()).contains("THERE ARE NO RESULTS FOR "),"Search result details is not as expected ");
	 }

	 /**
	  * Validating  Starwars Search field with Invalid data
	  *  No result for the data message should be shown
	  * @throws Exception
	  */
		
	 @Test(groups= {"FunctionalTest"})
	 public void validateSearchTestWithBlankField() throws Exception{
		 log.info("Logged in to Starwars Page Successfully");
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 homeObjects.setSearchStarWars(" ");
		 assertTrue((homeObjects.getSearchResultForblank()).contains("DATABANK"),"Search result details is not as expected, DataBank should show up");
	 }
	 
	 /**
	  * Validating  Starwars Search field with Alphanumeric
	  *  No result for the data message should be shown
	  * @throws Exception
	  */
		
	 @Test(groups= {"FunctionalTest"})
	 public void validateSearchTestWithAlphanumeric() throws Exception{
		 log.info("Logged in to Starwars Page Successfully");
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 homeObjects.setSearchStarWars("1");
		 assertTrue(homeObjects.getSearchResult(),"Search result not displayed");
	 }
	 
	 /**
	  * Validating  ShowDisney Option
	  * 
	  * Expected: Clicking on Show Disney option should show up Disney Options and Hide Disney Link
	  * @throws Exception
	  */
		
	 @Test(groups= {"FunctionalTest"})
	 public void validateShowAndHideDisneyOption() throws Exception{
		 homeObjects=new StarWarsHomePageObjects(driver);
		 lib=new StarwarsLibrary(driver);
			
		 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		 log.info("Logged in to Starwars Page Successfully");
		 homeObjects.clickShowDisney();
		 assertTrue(lib.isElementDisplayed(homeObjects.DisneyLogo),"Disney Logo is not shown");
		 assertTrue(lib.isElementDisplayed(homeObjects.HideDisney),"Hide Disney option is not shown");
		 homeObjects.HideDisney.click();
		 assertTrue(lib.isElementDisplayed(homeObjects.ShowDisney),"Show Disney Logo is not shown");
			
	 }
	
	 
	 /**
		 * 
		 * Validating Starwars Legal rights pages
		 * 
		 * Ensure all of the legal pages opens new window with the expected URL
		 * @param args
		 * @throws Exception
		 */
	     
		 @Test(groups= {"FunctionalTest"}, dataProvider="LegalRights")
		 public void verifyStarwarsLegalRightsLinksTest(String args[])  throws Exception{
			 StarWarsHomePageObjects homeObjects=new StarWarsHomePageObjects(driver);
			 StarwarsLibrary lib=new StarwarsLibrary(driver);
				
			 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
			 log.info("Logged in to Starwars Page Successfully");
				
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,3000)");
			 
			 String xpath=".//*[@id='legal']/li[--num--]/a";
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
			 * 
			 * Validating Starwars Home Page sections
			 * 
			 * Ensure all of theSections should be shown
			 * @param args
			 * @throws Exception
			 */
		     
			 @Test(groups= {"FunctionalTest"}, dataProvider="HomePageSections")
			 public void verifyStarwarsHomepAgeSections(String args[])  throws Exception{
				 StarWarsHomePageObjects homeObjects=new StarWarsHomePageObjects(driver);
				 StarwarsLibrary lib=new StarwarsLibrary(driver);
					
				 lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
				 log.info("Logged in to Starwars Page Successfully");
					
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,2000)");
				 
				 String xpath=".//*[@id='ref-1-num']/div/div/h2";
				 WebElement element= driver.findElement(By.xpath(xpath.replace("num", args[0])));
				 assertTrue(lib.isElementDisplayed(element)," Web element  not displayed");
				 String ActualTitle=element.getText();
				 assertTrue(ActualTitle.contains(args[1]),"Section header is not as expected,Actual::"+ActualTitle+" Expected::"+args[1]);
				 
				 		
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
	 
	 @DataProvider(name="LegalRights")
	    public Object[][] getDataFromDataproviderLegal(){
	    return new Object[][]
	    	{
	            { "1","Terms of Use | The Walt Disney Company","https://disneytermsofuse.com/" },
	            { "2", "https://help.disney.com/?ppLink=pp_wdig","https://help.disney.com/" },
	            { "3", "https://privacy.thewaltdisneycompany.com","https://privacy.thewaltdisneycompany.com" },
	            { "4","Children’s Privacy Policy","https://privacy.thewaltdisneycompany.com/" },
	            { "5","https://privacy.thewaltdisneycompany.com", "https://privacy.thewaltdisneycompany.com" },
	            { "6", "Guest Services","https://www.shopdisney.com" },
	            { "7","https://support.starwars.com/hc/en-us","https://support.starwars.com"},
	            { "8","Your Advertising Choices","http://preferences-mgr.truste.com/"}
	        };

	    }
	 
	 
	 	@DataProvider(name="HomePageSections")
	    public Object[][] getDataFromDataproviderHomePage(){
	    return new Object[][]
	    	{
	            { "7","THE LATEST" },
	            { "10", "STAR WARS CELEBRATION CHICAGO" },
	            { "11", "STAR WARS RESISTANCE " },
	            { "21","MORE LATEST NEWS" },
	            { "22","STAR WARS: IN PRODUCTION" },
	            { "24", "BEHIND THE SCENES" },
	           
	        };

	    }
}
