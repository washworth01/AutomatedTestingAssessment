package com.william.maven.cucumber.automatedTestingAssessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.william.maven.cucumber.automatedTestingAssessment.selenium.Constants;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationTestSteps
{
	private WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty(Constants.CHROMEDRIVER, Constants.CHROMEDRIVERLOCATION);
		driver = new ChromeDriver();
		driver.manage().window();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() 
	{
	    RegistrationTestRunner.test = RegistrationTestRunner.report.startTest("TestForm");
	    RegistrationTestRunner.test.log(LogStatus.INFO, "Traversing to website url");
	    driver.get(Constants.LANDINGPAGEURL);
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form() 
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "Clicking the link to form page");
	    LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
	    landingPage.clickAutomatedTestingFormLink();
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1)
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "Clicking the counrty dropdown");
		AutomatedTestingFormPage automatedTestingFormPage = PageFactory.initElements(driver, AutomatedTestingFormPage.class);
		automatedTestingFormPage.clickDropdownOption(arg1, driver);
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1)
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "Entering the email");
		AutomatedTestingFormPage automatedTestingFormPage = PageFactory.initElements(driver, AutomatedTestingFormPage.class);
		automatedTestingFormPage.enterEmail(arg1);
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) 
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "Entering the password");
		AutomatedTestingFormPage automatedTestingFormPage = PageFactory.initElements(driver, AutomatedTestingFormPage.class);
		automatedTestingFormPage.enterPassword(arg1);
	}
 
	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) 
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "Entering the confirmation password");
		AutomatedTestingFormPage automatedTestingFormPage = PageFactory.initElements(driver, AutomatedTestingFormPage.class);
		automatedTestingFormPage.enterConfirmPassword(arg1);
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message()
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "Checking if the form was a success");
	    AutomatedTestingFormPage automatedTestingFormPage = PageFactory.initElements(driver, AutomatedTestingFormPage.class);
	    automatedTestingFormPage.clickSubmit();
	    automatedTestingFormPage.formWasSuccessful();
	    if (automatedTestingFormPage.formWasSuccessful().contains("Success!"))
	    {
			RegistrationTestRunner.test.log(LogStatus.PASS, "The form was successful");

	    }
	    else
	    {
	    	RegistrationTestRunner.test.log(LogStatus.FAIL, "The form was unsuccessful");
	    }
	    assertEquals("Heading did not display Success!", "Success!", automatedTestingFormPage.formWasSuccessful());
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1)
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "Entering the wrong confirmation password");
		AutomatedTestingFormPage automatedTestingFormPage = PageFactory.initElements(driver, AutomatedTestingFormPage.class);
		automatedTestingFormPage.enterConfirmPassword(arg1);
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() 
	{
		RegistrationTestRunner.test.log(LogStatus.INFO, "checking the form informs user of mismatch");
		AutomatedTestingFormPage automatedTestingFormPage = PageFactory.initElements(driver, AutomatedTestingFormPage.class);
		automatedTestingFormPage.clickSubmit();
		automatedTestingFormPage.passwordDoNotMatch();
	    if (automatedTestingFormPage.passwordDoNotMatch().contains("The passwords do not match"))
	    {
			RegistrationTestRunner.test.log(LogStatus.PASS, "The Password do not match");

	    }
	    else
	    {
	    	RegistrationTestRunner.test.log(LogStatus.FAIL, "The Password do not match");
	    }
	    assertEquals("Heading did not display: The passwords do not match!", "The passwords do not match",  automatedTestingFormPage.passwordDoNotMatch());
	}
}
