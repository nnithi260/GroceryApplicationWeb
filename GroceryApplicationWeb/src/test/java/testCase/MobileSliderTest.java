package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant1.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MobileSlider;

public class MobileSliderTest extends baseClass {
	LoginPage lp;
	HomePage hp;
	MobileSlider ms;
  @Test
  public void MobileSliderTestPage() {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  ms=new MobileSlider(driver);
	  lp.sendUserName("admin");
		lp.sendPasswor("admin");
		lp.clickOnSignInButton();
		String actual = "Admin";
		String expected = hp.verifyMsg();
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogInWithInValidData);
		ms.MobileSliderPage();
		ms.AddNew();
	  
  }
}
