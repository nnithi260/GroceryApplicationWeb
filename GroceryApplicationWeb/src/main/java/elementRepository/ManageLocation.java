package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocation {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//div[11]//a[@class='small-box-footer']") 
	WebElement manageLocationMoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") 
	WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") 
	WebElement selectCountry;
	@FindBy(xpath = "//select[@id='st_id']") 
	WebElement selectState;
	@FindBy(xpath = "//input[@id='location']") 
	WebElement enterLocation;
	@FindBy(xpath = "//input[@id='delivery']") 
	WebElement deliveryCharge;
	@FindBy(xpath = "//button[@class='btn btn-danger']") 
	WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']") 
	WebElement saveMsg;
	@FindBy(xpath = "//a[@class='active nav-link']") 
	WebElement manageLocationSideButton;
	@FindBy(xpath = "//tr[1]//td[1]") 
	WebElement firstLoaction;
	public void ManageMoreInfo() {
		manageLocationMoreInfo.click();
		newButton.click();
		}
	public void CountryStateDropDown() {
		gu.selectDropDownUsingIndex(selectCountry,1);
		gu.selectDropDownUsingIndex(selectState,7);
	}
	public void LocationDetails() {
		enterLocation.sendKeys("Kochi"+gu.generateCurrentDateAndTime());
	}
	public void DeliveryCharge() {
		deliveryCharge.sendKeys("1298");
	}
	public void SaveButton() {
		saveButton.click();
	}
	public String AlerMsg() {
		return saveMsg.getText();
	}
	public void BackToManageLocation() {
		manageLocationSideButton.click();
	}
	public String FirstLoaction() {
		return firstLoaction.getText();
	}
}
