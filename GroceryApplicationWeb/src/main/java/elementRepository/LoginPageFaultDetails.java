package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFaultDetails {
	WebDriver driver;
	public LoginPageFaultDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//input[@name='username']") // to find the element in page factory
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath="//div//div[@class='alert alert-danger alert-dismissible']//h5")
	WebElement alertMsg;

	public void sendUserName() {
		usernameField.sendKeys("admin1");
	}
	public void sendPasswor() {
		passwordField.sendKeys("admina");
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public String getString() {
		return alertMsg.getText();
		
	}
	
}
