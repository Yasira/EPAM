package com.sw.ui.Starwars;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class StarwarsVideoPageTest extends CommonTest {
	
	
	    StarwarsSignUpPage pageObjects;
	    StarWarsHomePageObjects homeObjects;
	    StarwarsVideoPageObjects videoObjects;
	    StarwarsLibrary lib;
	   
	    /**
	     * Verify  Video Link Menu option
	     * 
	     *  Expected result: Video Menuoption should show up the video details
	     * @throws Exception
	     */
	    @Test(groups = { "FunctionalTest"})
	    public void verifyVideoMenuOptionTest()  throws Exception{
	    	
	    	pageObjects=new StarwarsSignUpPage(driver);
	    	homeObjects=new StarWarsHomePageObjects(driver);
	    	videoObjects= new StarwarsVideoPageObjects(driver);
	    	lib=new StarwarsLibrary(driver);
	          
	   	    lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		    assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
		    
		    videoObjects.clickVideoLink();
		    lib.waitForElementIsDisplayed(videoObjects.VideoSearchButton,30);
		    assertTrue(lib.isElementDisplayed(videoObjects.VideoSearchButton)," Video Search button  not displayed");
		    assertTrue(lib.isElementDisplayed(videoObjects.VideoSearchField)," Video search field not displayed");
		    assertTrue(lib.isElementDisplayed(videoObjects.FirstVideo)," First video image displayed");
		    assertTrue(lib.isElementDisplayed(videoObjects.FirstVideoTitle)," First Video title displayed");
			            
	    	
	    }
	    
	    /**
	     * Verify  Video Search bar option
	     * 
	     *  Expected result: Result videos should be shown
	     * @throws Exception
	     */
	    @Test(groups = { "FunctionalTest"})
	    public void verifyVideoSearchOptionTest()  throws Exception{
	    	
	    	pageObjects=new StarwarsSignUpPage(driver);
	    	homeObjects=new StarWarsHomePageObjects(driver);
	    	videoObjects= new StarwarsVideoPageObjects(driver);
	    	lib=new StarwarsLibrary(driver);
	          
	   	    lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		    assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
		    
		    videoObjects.clickVideoLink();
		    lib.waitForElementIsDisplayed(videoObjects.VideoSearchButton,30);
		    assertTrue(lib.isElementDisplayed(videoObjects.VideoSearchButton)," Video Search button  not displayed");
		    assertTrue(lib.isElementDisplayed(videoObjects.VideoSearchField)," Video search field not displayed");
		    videoObjects.setSearchVideo("Starwars");
		    lib.waitForElementIsDisplayed(videoObjects.SearchResultText,30);
			assertTrue(videoObjects.SearchResultText.getText().contains(("Starwars").toUpperCase()),"Not able to see the result in Star wars") ;  
		    assertTrue(lib.isElementDisplayed(videoObjects.ResultVideoLinks)," Result video links not displayed");
		              
	    	
	    }
	    
	    
	    /**
	     * Verify  Play Video option
	     * 
	     *  Expected result: Video should be able to play, pause or stop
	     * @throws Exception
	     */
	    @Test(groups = { "FunctionalTest"})
	    public void validatePlayingVideoTest()  throws Exception{
	    	
	    	pageObjects=new StarwarsSignUpPage(driver);
	    	homeObjects=new StarWarsHomePageObjects(driver);
	    	videoObjects= new StarwarsVideoPageObjects(driver);
	    	lib=new StarwarsLibrary(driver);
	          
	   	    lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		    assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
		    
		    videoObjects.clickVideoLink();
		    lib.waitForElementIsDisplayed(videoObjects.VideoSearchButton,30);
		    assertTrue(lib.isElementDisplayed(videoObjects.FirstVideo)," Video Search button  not displayed");
		    assertTrue(lib.isElementDisplayed(videoObjects.FirstVideoTitle)," Video search field not displayed");
		    videoObjects.clickViewVideoTitle();
		    assertTrue(lib.isElementDisplayed(videoObjects.FirstVideoResultPage)," Video search result not displayed");
		     String videoLink=videoObjects.clickOnResultVideo();
		     assertTrue(lib.isElementDisplayed(videoObjects.PlayVideo)," Play Video option not displayed");
			   
		    videoObjects.playVideo(videoLink);
			   
		              
	    	
	    }
	
	    
	    /**
	     * Verify  Browse Video Option
	     * 
	     *  Expected result: Result videos should be shown for all the browse links mentioned
	     * @throws Exception
	     */
	    @Test(groups = { "FunctionalTest1"})
	    public void verifyBrowseVideoOptionTest()  throws Exception{
	    	
	    	pageObjects=new StarwarsSignUpPage(driver);
	    	homeObjects=new StarWarsHomePageObjects(driver);
	    	videoObjects= new StarwarsVideoPageObjects(driver);
	    	lib=new StarwarsLibrary(driver);
	          
	   	    lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		    assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
		    
		    videoObjects.clickVideoLink();
		    lib.waitForElementIsDisplayed(videoObjects.VideoSearchButton,30);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		   // js.executeScript("window.scrollBy(0,4000)");
		    for(WebElement element:videoObjects.browseVideosLinks ) {
		    	
			    assertTrue(lib.isElementDisplayed(element)," Browse Video Option  not displayed");
			    Actions actions = new Actions(driver);
			    actions.moveToElement(element).click().perform();
			     Thread.sleep(2000);
			    js.executeScript("window.scrollBy(0,2000)");
			   // js.executeScript("arguments[0].scrollIntoView();", videoObjects.browseVideosLinksResultVideo);
			    lib.waitForElementIsDisplayed(videoObjects.browseVideosLinksResultVideo,10);
			    assertTrue(lib.isElementDisplayed(videoObjects.browseVideosLinksResultVideo)," Clicking on video browse option not listed the videos");
				   
		    }
	    	
	    }
	

}
