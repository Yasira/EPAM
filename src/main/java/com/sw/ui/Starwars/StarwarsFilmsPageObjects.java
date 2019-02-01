package com.sw.ui.Starwars;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class StarwarsFilmsPageObjects {
	
	private static final Logger log = Logger.getLogger(StarwarsFilmsPageObjects.class);

	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='section-links']/li[4]/a/span[2]")
	WebElement FilmsLink;
	
	@FindBy(xpath=".//*[@id='ref-1-1']/div[1]/div[2]/div/ul/div/div/div/div/div/div[2]/div[2]/div/h3/a")
	WebElement FirstFilmLink;
	
	@FindBy(xpath=".//*[@id='ref-1-1']/div[1]/div[2]/div/ul/div/div/div/div/div/div[1]/div/a/img")
	WebElement FirstFilmImage;
	
	@FindBy(xpath=".//*[@id='film-selector']/div/div/label")
	WebElement SeeAllOption;
	
	@FindBy(xpath=".//*[@id='film-selector']/div/ul/li[2]/span/a")
	WebElement SeeAllFirstFilm;
	
	@FindBy(xpath=".//*[@id='ref-1-1']/div/div[2]/img")
	WebElement MoviewTitle;
	
	@FindBy(xpath="//div[@class='purchase_product']/a")
	WebElement BuyMovie;
	
	@FindBy(xpath="//div[@class='cta']/div/a[contains(.,'IMDB')]")
	WebElement ViewIMDB;
	
	@FindBy(xpath="//div[@class='cta']/div/a[contains(.,'Wookieepedia')]")
	WebElement ViewWookee;
	
	@FindBy(xpath=".//*[@id='ref-1-2']/div/div/h2[contains(.,'Characters ')]")
	WebElement Characters;
	
	@FindBy(xpath=".//*[@id='ref-1-1']/div/div[2]/div[2]/div[1]/div/div/ul/li/a")
	WebElement BuyMovieOptions;
	
    StarwarsLibrary  lib;

	
	
	public StarwarsFilmsPageObjects(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		lib=new StarwarsLibrary(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickFilmsLink() throws Exception {
		FilmsLink.click();
		lib.waitForElementIsDisplayed(FirstFilmLink, 20);
		
	}
	
	public void  clickSeeAllOption() throws Exception{
		SeeAllOption.click();
		lib.waitForElementIsDisplayed(SeeAllFirstFilm, 15);
		log.info("Click on See All option");
	}
	
	public void clickFilmTitle() throws Exception {
		FilmsLink.click();
		lib.waitForElementIsDisplayed(MoviewTitle, 20);
		log.info("Click on movie link");
		
	}
	
	public void clickFilmImage() throws Exception {
		FilmsLink.click();
		lib.waitForElementIsDisplayed(MoviewTitle, 20);
		log.info("Click on movie image");
		
	}
	
}
