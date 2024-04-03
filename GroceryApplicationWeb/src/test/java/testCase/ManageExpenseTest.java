package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant1.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpense;

public class ManageExpenseTest extends baseClass {
	LoginPage lp;
	ManageExpense mep;
	HomePage hp;

	@Test
	public void manageExpense() {
		lp = new LoginPage(driver);
		mep = new ManageExpense(driver);
		hp=new HomePage(driver); 
		lp.sendUserName("admin");
		lp.sendPasswor("admin");
		lp.clickOnSignInButton();
		String actual="Admin";
		String expected=hp.verifyMsg();
		Assert.assertEquals(actual,expected,Constant.lp_verifyLogInWithInValidData);
		mep.scroll();
		mep.manageExpenseWait();
		mep.ManageExpenseTab();
		mep.AddNewExpense();
		mep.UserIDropDown();
		mep.ExpenseTypeDropDown();
		mep.EnterExpenseAmont();
		mep.FileToUpload();
		mep.SaveButtonClick();
		mep.backToHome();
		mep.ManageExpenseTab();
		String actual2="£ 1234";
		String expected2=mep.readElement();
		Assert.assertEquals(actual2,expected2,Constant.lp_verifyLogInWithInValidData);
		

	}
}
