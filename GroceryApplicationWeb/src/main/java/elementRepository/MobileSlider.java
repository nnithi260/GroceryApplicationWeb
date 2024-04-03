package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobileSlider {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public MobileSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//div[12]//a[@class='small-box-footer']")
	WebElement mobileSliderInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewMobileSliderButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement SelectDropDown;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement ImageUpload;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMsg;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-window-minimize']")
	WebElement MobileSilderPage;
	public void MobileSliderPage() {
		mobileSliderInfo.click();
		}
	public void AddNew() {
		NewMobileSliderButton.click();
		gu.selectDropDownUsingIndex(SelectDropDown, 5);
		ImageUpload.sendKeys("C:\\\\Users\\\\admin\\\\Desktop\\\\Screenshot (122).png");
		saveButton.click();
	}
	
	
	
	
	
	
	
	
	

	

}
