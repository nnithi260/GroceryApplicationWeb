package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageExpense {
	WebDriver driver;
	GeneralUtilities gu= new GeneralUtilities();

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	
	//@FindBy(xpath = "//div[@style='background-color:purple !important;']//a[@class='small-box-footer']")
	@FindBy(xpath = "//div//div[14]//a[@class='small-box-footer']")
	WebElement manageExpenseMoreInfo;
	//div[14]//a[@class='small-box-footer']
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addExpenseButton;
	@FindBy(xpath = "//select[@id='user_id']")
	WebElement userIdDropDown;
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement expenseTypeDropDown;
	@FindBy(xpath = "//input[@id='amount']")
	WebElement enterAmount;
	@FindBy(xpath = "//input[@name='userfile']")
	WebElement fileUpload;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	WebElement homePage;
	@FindBy(xpath = "//tr[1]//td[3]")
	WebElement amountFinder;
	public void scroll() {
		gu.scroll(driver);
	}
	public void manageExpenseWait() {
		WaitUtilities wait = new WaitUtilities();
		wait.explicitWaitForWebElement(driver, manageExpenseMoreInfo, 5000);
	}
	public void ManageExpenseTab() {
		gu.click(driver, manageExpenseMoreInfo);
	}
	public void AddNewExpense() {
		addExpenseButton.click();
	}
	public void UserIDropDown() {
		 gu.selectDropDownUsingIndex(userIdDropDown, 2);
	}
	public void ExpenseTypeDropDown() {
		 gu.selectDropDownUsingIndex(expenseTypeDropDown, 2);
	}
	public void EnterExpenseAmont() {
		enterAmount.sendKeys("1234");
	}
	public void FileToUpload() {
		fileUpload.sendKeys("C:\\Users\\admin\\Desktop\\Screenshot (122).png");
	}
	public void SaveButtonClick() {
		saveButton.submit();
	}
	public String AlertMessage() {
		return alertMsg.getText();
	}
	public void backToHome() {
		homePage.click();
	}
	public String readElement() {
		 return amountFinder.getText();	
	}
}
