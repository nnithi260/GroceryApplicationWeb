package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsers {
WebDriver driver;
GeneralUtilities gu= new GeneralUtilities();
	
	public AdminUsers(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//div//div[2]//a[@class='small-box-footer']")
	WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewUserButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement addUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement addPassWord;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropDown; 
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement saveButton;
	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement userPhoto;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logOutButton;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement signInPage;
	
	
	


	public void AdminUserInfo() {
		adminUsersMoreInfo.click();
		addNewUserButton.click();
		
		//serNameField.sendKeys(username+gu.generateCurrentDateAndTime());//kerala130324065630
	}
	public void UserData() {
		addUserName.sendKeys("123"+gu.generateCurrentDateAndTime());
		addPassWord.sendKeys("Hi@123");	
	}
	public void UserDropDown() {   
		gu.selectDropDownUsingIndex(userTypeDropDown,2);
	}
	public void SaveButton() {   
		 saveButton.click();
		
	}
	public void LogOut() {
		 userPhoto.click();
		 logOutButton.click();
		
	}
	public String SignInText() {
	return signInPage.getText();
	}
	}

	
	