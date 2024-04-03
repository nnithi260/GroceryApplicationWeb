package elementRepository;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageNews {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	@FindBy(xpath = "//div[13]//a[@class='small-box-footer']")
	WebElement manageNewsMoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNews;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement saveMsg;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-th-large']")
	WebElement dashBoard;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement elementToBeSearched;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement startSearch;
	//List<WebElement> tableElementRow;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
		//tableElementRow = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
	}
	public void NewsMoreInfo() {
		gu.click(driver, manageNewsMoreInfo);
	}
	public void NewsAdd() {
		addNewsButton.click();
		enterNews.sendKeys("HAPPY NEW YEAR");
		saveButton.click();
		
	}
	public String SuccessMsg() {
		return saveMsg.getText();
	}
	public void DashBoard() {
		dashBoard.click();
	}
	public void SearchElement() {
		searchButton.click();
		elementToBeSearched.sendKeys("HAPPY NEW YEAR");
		startSearch.click();	
	}
	public int table() {
		 List <WebElement> tableElementRow=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr"));
		 return tableElementRow.size();
	}
	

	
	}


