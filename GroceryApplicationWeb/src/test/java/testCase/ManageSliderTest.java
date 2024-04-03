package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant1.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSlider;

public class ManageSliderTest extends baseClass {
	LoginPage lp;
	HomePage hp;
	ManageSlider mst;

	@Test
	public void ManageSliderTestPage() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mst = new ManageSlider(driver);
		lp.sendUserName("admin");
		lp.sendPasswor("admin");
		lp.clickOnSignInButton();
		String actual = "Admin";
		String expected = hp.verifyMsg();
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogInWithInValidData);
		mst.ManageSliderPage();
		mst.FileUpload();
		String expected1=mst.AlertMsg();
		String actual1="Alert!";
		Assert.assertEquals(actual1, expected1, Constant.lp_verifyLogInWithInValidData);
		mst.BackToList();
		String expected2=mst.ElementRead();
		String actual2="WWW.ECLIPSE.COM";
		Assert.assertEquals(actual2, expected2, Constant.Element_Missing);
		mst.DeleteOperation();
		String expected3=mst.ElementRead();
		String actual3="WWW.ECLIPSE.COM";
		//Assert.assertEquals(actual3, expected3, Constant.Element_Missing);
	}
}
