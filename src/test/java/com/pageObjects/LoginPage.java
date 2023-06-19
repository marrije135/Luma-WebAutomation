package com.pageObjects;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class LoginPage extends BasePage {
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;
//	public WebDriver ldriver;

	// Constructor

	public LoginPage(WebDriver driver) {
		super(driver);
		// ldriver = rdriver;
		// PageFactory.initElements(ldriver, this);
	}

	// Capture email field
	@FindBy(xpath = "//span[contains(text(),'Log in/Sign up')]")
	@CacheLookup
	public WebElement loginbtn;

	@FindBy(xpath = "//input[@id='mat-input-0']")
	@CacheLookup
	public WebElement emailTxt;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	public WebElement pwdText;
	
	//@FindBy(xpath = "//button[contains(text(),'login')]")
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement loginsubmitbtn;

	@FindBy(xpath = "//span[contains(text(),'Hi, Automation')]")
	@CacheLookup
	public WebElement nameLink;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	public WebElement signoutbtn;
	
	//@FindBy(xpath = "//div[@class='wo-order-now-btn']/child:: button")
	@FindBy(xpath = "//header/div[2]/div[2]/div[3]/button[1]")
	public WebElement orderNowBtn;
	
	@FindBy(xpath="//button[contains(text(),'PICKUP')]")
	//@FindBy(xpath = "//pickup-delivery[@class='wo-freshii-pickup-delivery-component ng-star-inserted']/child::button[1]")
	@CacheLookup
	public WebElement pickUpBtn;

	// ==================Action methods===========================//

	public void loginclick() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}

	// Send text to the email field
	public void settxtemail(String email) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emailTxt));
		emailTxt.sendKeys(email);
	}

	// Send text to password field
	public void settxtpassword(String pwd) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(pwdText));
		pwdText.sendKeys(pwd);
	}

	// Click on submit button
	public void clkbtnSubmit() throws TimeoutException {
		//wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(loginsubmitbtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600);");
		wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(loginsubmitbtn));
		driver.switchTo().activeElement();
		loginsubmitbtn.click();
	}


}
