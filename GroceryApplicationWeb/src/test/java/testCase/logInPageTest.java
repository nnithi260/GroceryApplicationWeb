package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant1.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class logInPageTest extends baseClass {
	LoginPage lp;
	HomePage hp;
	

	@DataProvider (name = "data-provider-Invalid credential")  //to run test more times using different values. use in login page
	public Object[][] dp1Method(){
	return new Object[][] {{"Admin122","Admin1111"},{"adddd","passsss"}};
	}

	@Test(groups="RegressionTest")
	public void verifyLogInWithValidData(){
		lp= new LoginPage(driver);
		hp=new HomePage(driver);
		//er=new ExcelRead(driver);
		
		
		lp.sendUserName("admin");
		lp.sendPasswor("admin");
		lp.clickOnSignInButton();
		String expected="Admin";
		String actual=hp.verifyMsg();
		System.out.println(actual);
		Assert.assertEquals(actual,expected,"Admin-text-found");
		
	}
	@Test(dataProvider="data-provider-Invalid credential")
	public void verifyLogInWithInValidData( String username, String password) throws InterruptedException {
		lp= new LoginPage(driver);
		hp=new HomePage(driver); 
		lp.sendUserName(username);
		lp.sendPasswor(password);
		lp.clickOnSignInButton();
		//Thread.sleep(2000);
		String expected="Alert!";
		String actual=lp.getString();
		//System.out.println(actual);
		Assert.assertEquals(actual,expected,Constant.lp_verifyLogInWithInValidData);
		
	}
	@Test(groups="RegressionTest")
	public void verifyLoginWithValidExcelData() throws IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		//ExcelUtilities eu= new ExcelUtilities();
	//	String user= ExcelUtilities.getStringData1(1, 1);
	//	String pass=ExcelUtilities.getStringData1(2, 1);
	//	System.out.println("Username on excel is"+user);
	//	System.out.println("Password on excel is"+pass);
		
		lp.sendUserName(ExcelRead.getStringData(1, 1));
		lp.sendPasswor(ExcelRead.getStringData(2, 1));
		lp.clickOnSignInButton();
		String expected = "Admin";
		String actual = hp.verifyMsg();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "title not as expected");

	}
}
