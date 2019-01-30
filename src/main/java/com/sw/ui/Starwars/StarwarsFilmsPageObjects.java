package com.sw.ui.Starwars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StarwarsFilmsPageObjects {
	
	

	WebDriver driver;
	
	@FindBy(className="section-link films-content active")
	WebElement FilmsLink;
	
	@FindBy(xpath="//div[@class='content-wrapper']/div[@class='content-bumper']/div/h3")
	WebElement FirstFilm;
	
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
	
	
}
