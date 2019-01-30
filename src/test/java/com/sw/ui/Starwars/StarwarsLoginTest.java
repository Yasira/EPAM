package com.sw.ui.Starwars;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class StarwarsLoginTest extends CommonTest {
	
	
	    private Properties properties = new Properties();
	    StarwarsSignUpPage pageObjects;
	    StarWarsHomePageObjects homeObjects;
	    StarwarsLibrary lib;
	   
	    /**
	     * Verify  Sign In to Starwars with Valid Account
	     * 
	     *  Expected result: User should be able to login successfully
	     * @throws Exception
	     */
	    @Test(groups = { "FunctionalTest"})
	    public void starwarsSignInTest()  throws Exception{
	    	
	    	pageObjects=new StarwarsSignUpPage(driver);
	    	homeObjects=new StarWarsHomePageObjects(driver);
	    	lib=new StarwarsLibrary(driver);
	        properties.load(new FileReader(new File(System.getProperty("user.dir")+"\\configdata\\config.properties")));
	          
	   	    lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		    assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
	        //Login in to the starwars account
	        homeObjects.clickSignInLink();
	        Thread.sleep(2000);
	        driver.switchTo().frame(0);
	        //lib.waitForElementIsDisplayed(pageObjects.username,20);
		    pageObjects.setEmailId(properties.getProperty("username"));
	        pageObjects.setPassword(properties.getProperty("password"));
	        pageObjects.clickSignIn();
	        assertTrue(lib.isElementDisplayed(pageObjects.UserID),"UserID not displayed after Logging in");
	        
	    	
	    	
	    }
	    
	    /**
	     * @Test 
	     * Validate the SignUp page
	     * Expected: Clicking on the Sign Up link should show up sign up page with all the foelds editable
	     * @throws Exception
	     */
	    
	    @Test(groups = { "FunctionalTest"})
	    public void starwarsSignUpPageValidationTest()  throws Exception{
	    	
	    	pageObjects=new StarwarsSignUpPage(driver);
	    	homeObjects=new StarWarsHomePageObjects(driver);
	    	lib=new StarwarsLibrary(driver);
	    	properties.load(new FileReader(new File(System.getProperty("user.dir")+"\\configdata\\config.properties")));
		      
	        lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		    assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
		    homeObjects.clickSignUpLink();
		    
		    driver.switchTo().frame(0);
		    //lib.waitForElementIsDisplayed(pageObjects.firstName,30);
			  
		    assertTrue(lib.isElementDisplayed(pageObjects.firstName)," FirstName field  not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.displayName)," Display name field  not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.emailId)," Email ID field  not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.lastName)," Last Name Fiels  not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.passwordSign)," Password field  not displayed");
			     
		    assertTrue(lib.isElementDisplayed(pageObjects.birthDate)," Birth date field not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.birthMonth)," Birth Month field  not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.birthYear)," Birth Year field not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.showPassword)," Show Password text  not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.showPasswordCheckbox)," Show Password checkbox not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.updates)," Updates notification checkbox not displayed");
		    assertTrue(lib.isElementDisplayed(pageObjects.createNewAccount)," Create Account button  not displayed");
			   
	     
	    }
	    
	    
	    @Test(groups = { "FunctionalTest"},dataProvider="InvalidLoginDetails")
	    public void starwarsLoginWithInavlidDataTest(String args[])  throws Exception{
	    	pageObjects=new StarwarsSignUpPage(driver);
	    	homeObjects=new StarWarsHomePageObjects(driver);
	    	lib=new StarwarsLibrary(driver);
	        properties.load(new FileReader(new File(System.getProperty("user.dir")+"\\configdata\\config.properties")));
	          
	   	    lib.waitForElementIsDisplayed(homeObjects.StarwarsLogo,30);
		    assertTrue(lib.isElementDisplayed(homeObjects.StarwarsLogo)," StarWars Logo not displayed");
	        //Login in to the starwars account
	        homeObjects.clickSignInLink();
	        Thread.sleep(2000);
	        driver.switchTo().frame(0);
	        //lib.waitForElementIsDisplayed(pageObjects.username,20);
		    pageObjects.setEmailId(properties.getProperty(args[0]));
	        pageObjects.setPassword(properties.getProperty(args[1]));
	        pageObjects.clickSignIn();
	        lib.waitForElementIsDisplayed(pageObjects.InvalidDetails,20);
	        assertTrue(lib.isElementDisplayed(pageObjects.InvalidDetails)," StarWars Logo not displayed");
		    assertTrue(pageObjects.InvalidDetails.getText().contains(args[2]),"Error message is not as expected, Expected"+ args[2]);  
	     
	    }
	    
	    
	    @DataProvider(name="InvalidLoginDetails")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][]
	    	{
	            { "yasihere@gmail.com"," ","We need your username/email address and password." },
	            { " ", "Starwars123#","We need your username/email address and password." },
	            { "test@gmail.com", "test123#","The credentials you entered are incorrect." },
	            { " "," ","We need your username/email address and password." },
	            { "yasihere@gmail.com", "yetdtey","The credentials you entered are incorrect." },
	            { "test", " ","We need your username/email address and password." }
	        };

	    }
	 

}
