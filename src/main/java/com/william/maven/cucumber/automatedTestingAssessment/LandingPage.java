package com.william.maven.cucumber.automatedTestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LandingPage
{
	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement automatedTestingFormLink;
	
	public void clickAutomatedTestingFormLink()
	{
		automatedTestingFormLink.click();
	}
}
