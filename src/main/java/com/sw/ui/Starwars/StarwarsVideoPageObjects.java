package com.sw.ui.Starwars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StarwarsVideoPageObjects {
	
WebDriver driver;
	
	@FindBy(className="section-icon video-icon")
	WebElement VideoLink;
	
	@FindBy(id="nav-search-input")
	WebElement SearchField;
	
	@FindBy(xpath="//input[@class='large button']")
	WebElement SearchButton;
	
	@FindBy(xpath=".//*[@id='ref-1-1']/div[1]/div[2]/div/ul/div/div/div/div/div/div[1]/div/a")
	WebElement FirstVideo;
	
	@FindBy(xpath="//div[@class='content-bumper']/div/h3[@class='title']/a/span[@class='long-title'][contains(.,'The Star Wars Show')]")
	WebElement FirstVideoTitle;
	
	@FindBy(xpath=".//*[@id='ref-1-0']/div[1]")
	WebElement FirstVideoStream;
	

}
