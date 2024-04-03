package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant1.Constant;
import utilities.ExtenetReport;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageNews;

public class ManageNewsTest extends baseClass {
	LoginPage lp;
	HomePage hp;
	ManageNews mn;

	@Test
	public void ManageNewsPage() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mn = new ManageNews(driver);
		lp.sendUserName("admin");
		lp.sendPasswor("admin");
		lp.clickOnSignInButton();
		String actual = "Admin";
		String expected = hp.verifyMsg();
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogInWithInValidData);
		mn.NewsMoreInfo();
		mn.NewsAdd();
		String expected1=mn.SuccessMsg();
		String actual1="Alert!";
		Assert.assertEquals(actual1, expected1, Constant.Element_Missing);
		mn.DashBoard();
		mn.NewsMoreInfo();
		mn.SearchElement();
		int a=mn.table();
		System.out.println(a);

	}
}
