package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant1.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.PushNotification;

public class PushNotificationTest extends baseClass {
	LoginPage lp;
	HomePage hp;
	PushNotification pn;

	@Test
	public void pushNotification() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pn = new PushNotification(driver);
		lp.sendUserName("admin");
		lp.sendPasswor("admin");
		lp.clickOnSignInButton();
		String actual = "Admin";
		String expected = hp.verifyMsg();
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogInWithInValidData);
		pn.pushNotificationButton();
		String expected1 = pn.SuccesfulMsg();
		String actual1 = "Alert!";
		Assert.assertEquals(actual1, expected1, Constant.lp_verifyLogInWithInValidData);
	}
}
