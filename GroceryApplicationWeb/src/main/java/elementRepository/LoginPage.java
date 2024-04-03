package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	// By userNameField=By.name("username"); //page object model without page
	// factory
	@FindBy(xpath = "//input[@name='username']") // to find the element in page factory
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath="//div//div[@class='alert alert-danger alert-dismissible']//h5")
	WebElement alertMsg;
	@FindBy(xpath="//a[@class='d-block']")
	WebElement successMsg;
	

	public void sendUserName( String username) {
		usernameField.sendKeys(username);
	}
	public void sendPasswor(String password) {
		passwordField.sendKeys(password);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public String getString() {
		return alertMsg.getText();
	}
}
