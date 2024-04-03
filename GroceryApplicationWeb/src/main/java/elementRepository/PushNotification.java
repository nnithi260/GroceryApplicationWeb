package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotification {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotification(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	WebElement pushNotification;
	@FindBy(xpath = "//input[@id='title']")
	WebElement enterTitle;
	@FindBy(xpath = "//input[@id='description']")
	WebElement enterDescription;
	@FindBy(xpath = "//i[@class='fa fa-bell']")
	WebElement sendButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement succesfulMsg;
	

	public void pushNotificationButton() {
		pushNotification.click();
		enterTitle.sendKeys("GREAT OFFER");
		enterDescription.sendKeys("50% OFFER !");
		sendButton.click();
	}

	public String SuccesfulMsg() {
		return succesfulMsg.getText();
	}

}
