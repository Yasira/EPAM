package com.sw.ui.Starwars;

import java.util.List;


import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class StarwarsVideoPageObjects {
	
	private static final Logger log = Logger.getLogger(StarwarsVideoPageObjects.class);
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='section-links']/li[2]/a/span[2]")
	WebElement VideoLink;
	
	@FindBy(xpath=".//*[@id='ref-1-0']/div/form/div[2]/input[1]")
	WebElement VideoSearchField;
	
	@FindBy(xpath="//input[@class='large button']")
	WebElement VideoSearchButton;
	
	@FindBy(xpath=".//*[@id='ref-1-1']/div[1]/div[2]/div/ul/div/div/div/div/div/div[1]/div/a")
	WebElement FirstVideo;
	
	@FindBy(xpath="//div[@class='content-bumper']/div/h3[@class='title']/a/span[@class='long-title'][contains(.,'The Star Wars Show')]")
	WebElement FirstVideoTitle;
	
	@FindBy(xpath=".//*[@id='ref-1-0']/div[1]")
	WebElement FirstVideoStream;
	
	@FindBy(xpath=".//*[@id='nav-ac']/li[1]/a")
	WebElement FirstSearchResultPopup;
	
	@FindBy(xpath=".//*[@id='main']/div/div/div[2]/div[1]/h2")
	WebElement SearchResultText;
	
	
	@FindBy(xpath=".//*[@id='ref-1-0']/div[1]/div/div/ul/div/div/div/div/div/div[2]/div[2]/div/h3/a")
	WebElement FirstVideoResultPage;
	
	@FindBy(css="#player-gui > div.playkit-overlay-action")
	WebElement PlayVideo;
	
	
	@FindBy(xpath=".//*[@id='main']/div/div/div[2]/div[2]/section/ul/li/div[1]/a/h3")
	WebElement ResultVideoLinks;
	
	@FindBy(xpath=".//*[@id='ref-1-5']/div[1]/div/ul/li")
	List <WebElement> browseVideosLinks;
	
	
	@FindBy(xpath=".//*[@id='ref-1-5']/div[1]/div[3]/div/ul/div[1]/div/div/div")
     WebElement browseVideosLinksResultVideo;
	
	//@FindBy(css="#player-gui > div.playkit-bottom-bar > div.playkit-left-controls > div.playkit-control-button-container.playkit-control-play-pause > button > div > i.playkit-icon.playkit-icon-play")
	@FindBy(css="#player-gui > div.playkit-bottom-bar > div.playkit-left-controls > div.playkit-playback-controls > div > button > div > i.playkit-icon.playkit-icon-play")
    WebElement playVideoIcon;
	
	
	//@FindBy(css="#player-gui > div.playkit-bottom-bar > div.playkit-left-controls > div.playkit-control-button-container.playkit-control-play-pause > button > div > i.playkit-icon.playkit-icon-pause")
	@FindBy(css="#player-gui > div.playkit-bottom-bar > div.playkit-left-controls > div.playkit-playback-controls > div > button > div > i.playkit-icon.playkit-icon-pause")
    WebElement pauseVideoIcon;
	
	
	@FindBy(css="#player-gui > div.playkit-bottom-bar > div.playkit-right-controls > div.playkit-control-button-container.playkit-volume-control > button > i.playkit-icon.playkit-icon-volume-waves")
    WebElement VideoVolumeIcon;
	
	@FindBy(xpath=".//*[@id='main']/div/div/div[2]/div/h2")
	WebElement VideoSearchNoResult;
	
	
	
	StarwarsLibrary  lib;
	
	
	public StarwarsVideoPageObjects(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		lib=new StarwarsLibrary(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickVideoLink() throws Exception {
		VideoLink.click();
		lib.waitForElementIsDisplayed(VideoSearchField, 20);
		log.info("Click on video link");
	}
	
	public void setSearchVideo(String videoname) {
		VideoSearchField.sendKeys(videoname);
		VideoSearchButton.click();
		log.info("Search for  video link");
		
	}
	
	public void  clickViewVideoTitle()throws Exception {
		FirstVideoTitle.click();
		lib.waitForElementIsDisplayed(FirstVideoResultPage, 30);
	}
	
	public void checkAutoPopVideoOption(String video) {
		VideoSearchField.sendKeys(video);
		log.info("Drop down shown for Video details");
	}

	public String clickOnResultVideo() throws Exception{
		
		String urlStr = FirstVideoResultPage.getAttribute("href");
		FirstVideoResultPage.click();
		lib.mouseOver(PlayVideo);
		//lib.waitForElementIsDisplayed(PlayVideo, 30);
		log.info("Result video shown::"+urlStr);
		return urlStr;
	}
	
	
	
	
}
