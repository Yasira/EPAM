package com.sw.ui.Starwars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StarWarsHomePageObjects {
	

	WebDriver driver;
	
	@FindBy(id="nav-sw-logo")
	WebElement StarwarsLogo;
	
	@FindBy(xpath=".//*[@id='nav-search-input']")
	WebElement SearchField;
	
	@FindBy(xpath=".//*[@id='nav-utility']/div[2]/div[1]/div[2]")
	WebElement SignUp;
	
	@FindBy(xpath=".//*[@id='nav-utility']/div[2]/div[1]/div[1]")
	WebElement SignInLink;
	
	@FindBy(className="facebook facebook-icon")
	WebElement FacebookLink;
	
	@FindBy(className="tumblr tumblr-icon")
	WebElement TumblerLink;
	
	@FindBy(className="twitter twitter-icon")
	WebElement TwitterLink;
	
	@FindBy(className="instagram instagram-icon")
	WebElement InstagramLink;
	
	@FindBy(className="google_plus google_plus-icon")
	WebElement GoogleLink;
	
	@FindBy(className="youtube youtube-icon")
	WebElement YoutubeLink;
	
	@FindBy(xpath="//div[@id='chrome-controls']/span[@class='chrome-show']")
	WebElement ShowDisney;
	
	@FindBy(xpath="//div[@id='chrome-controls']/span[@class='chrome-hide']")
	WebElement HideDisney;
	
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'News + Blog')]")
	WebElement NewsLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[1]/a/span[1]")
	WebElement NewsLogo;
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'Video')]")
	WebElement VideoLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[2]/a/span[1]")
	WebElement VideoLogo;
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'Events')]")
	WebElement EventsLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[3]/a/span[1]")
	WebElement EventsLogo;
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'Films')]")
	WebElement FilmsLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[3]/a/span[1]")
	WebElement FilmsLogo;
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'TV Shows')]")
	WebElement TVShowsLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[4]/a/span[1]")
	WebElement TVShowsLogo;
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'Games')]")
	WebElement GamesLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[6]/a/span[1]")
	WebElement GamesLogo;
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'Community')]")
	WebElement CommunityLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[1]/a/span[1]")
	WebElement CommunityLogo;
	
	@FindBy(xpath="//ul[@id='section-links']/li/a/p[contains(.,'Community')]")
	WebElement DataBankLink;
	
	@FindBy(xpath=".//*[@id='section-links']/li[8]/a/span[1]")
	WebElement DataBankLogo;
	
	
	@FindBy(xpath=".//*[@id='goc-desktop-global']/li[1]/a")
	WebElement DisneyLogo;
	
	
	@FindBy(xpath=".//*[@id='main']/div/div/div[2]/div[1]/h2")
	WebElement SearchResultText;
	
	
	StarwarsLibrary  lib;
	
	
	public StarWarsHomePageObjects(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		lib=new StarwarsLibrary(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignInLink() {
		SignInLink.click();
	}
	
	public void clickSignUpLink() {
		SignUp.click();
	}
	
	public void clickShowDisney()  throws Exception{
		ShowDisney.click();
		lib.waitForElementIsDisplayed(DisneyLogo, 20);
		
	}
	
	public void setSearchStarWars(String starwars)  throws Exception{
		
		SearchField.sendKeys(starwars);
		SearchField.submit();
		Thread.sleep(5000);
	}
	
	public boolean getSearchResult() throws Exception{
		return lib.isElementDisplayed(SearchResultText);
	}
}
