package com.william.maven.cucumber.automatedTestingAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AutomatedTestingFormPage
{
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement countryDropdown;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement countryUnitedKingdom;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement countryFrance;	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement countryGermany;
	
	@FindBy(xpath = "//*[@id=\"nameInput\"]")
	private WebElement emailBox;
	
	@FindBy(xpath = "//*[@id=\"passInput\"]")
	private WebElement passwordBox;
	
	@FindBy(xpath = "//*[@id=\"passInput2\"]")
	private WebElement confirmPasswordBox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement successHeaderMessage;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/p[10]")
	private WebElement passwordsDoNotMatchMessage;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submit;
	
	public void clickDropdownOption(String option, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(countryDropdown).perform();
		
		if(countryUnitedKingdom.getAttribute("innerText").equals(option))
		{
			countryUnitedKingdom.click();
		}
		else if(countryFrance.getAttribute("innerText").equals(option))
		{
			countryFrance.click();
		}
		else if(countryGermany.getAttribute("innerText").equals(option))
		{
			countryGermany.click();
		}
	}
	
	public void enterEmail(String email)
	{
		emailBox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordBox.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password)
	{
		confirmPasswordBox.sendKeys(password);
	}
	
	public String formWasSuccessful()
	{
		return successHeaderMessage.getAttribute("innerText");
	}
	
	public String passwordDoNotMatch()
	{
		return passwordsDoNotMatchMessage.getAttribute("innerText");
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
}
