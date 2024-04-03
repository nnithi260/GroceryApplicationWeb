package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSlider {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//div[7]//a[@class='small-box-footer']")
	WebElement manageSliderMoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageUpload;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement link;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMsg;
	@FindBy(xpath = "//a[@class='active nav-link']")
	WebElement mobileSliderList;
	@FindBy(xpath = "//tr[1]//td[2]")
	WebElement sliderElement;
	@FindBy(xpath = "//tr[1]//td[4]//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;

	public void ManageSliderPage() {
		manageSliderMoreInfo.click();
		newButton.click();
	}

	public void FileUpload() {
		imageUpload.sendKeys("C:\\Users\\admin\\Desktop\\Screenshot (122).png");
		link.sendKeys("WWW.ECLIPSE.COM");
		saveButton.click();
	}

	public String AlertMsg() {
		return alertMsg.getText();
	}

	public void BackToList() {
		mobileSliderList.click();
	}

	public String ElementRead() {
		return sliderElement.getText();
	}

	public void DeleteOperation() {
		deleteButton.click();
		driver.switchTo().alert().accept();
	}

}
