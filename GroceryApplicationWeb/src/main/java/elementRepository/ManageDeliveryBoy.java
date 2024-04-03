package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	WebDriver driver;
	GeneralUtilities gu= new GeneralUtilities();
	
	public ManageDeliveryBoy(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//div[8]//a[@class='small-box-footer']")
	WebElement manageDeliveryMoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewDeliveryBoy;
	@FindBy(xpath = "//input[@id='name']")
	WebElement enterName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement enterEmail;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMsg;	
	@FindBy(xpath = "//tr//td[1]")
	WebElement readFromTable;
	
	
	
	public void manageInfo() {
		manageDeliveryMoreInfo.click();
	}
	public void addDeliveryBoy() {
		gu.click(driver, addNewDeliveryBoy);
	}
	public void enterName() {
		enterName.sendKeys("happy"+gu.generateCurrentDateAndTime());
		
	}
	public void eMailId() {
		enterEmail.sendKeys("abcdefghi@gmail.com");
	}
	public void userName() {
		userName.sendKeys("happy@1"+gu.generateCurrentDateAndTime());	
	}
	public void passWord() {
		password.sendKeys("123456171");
	}
	public void saveButtonOp() {
		saveButton.submit();	
	}
	public String readAlertMsg() {
		return alertMsg.getText();
	}
	public String readFromTableName() {
		return readFromTable.getText();
	}
	
	
	
}
