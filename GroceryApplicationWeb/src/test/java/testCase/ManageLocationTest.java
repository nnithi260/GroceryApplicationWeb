package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant1.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageLocation;
import utilities.GeneralUtilities;

public class ManageLocationTest extends baseClass {
	LoginPage lp;
	HomePage hp;
	ManageLocation ml;
	GeneralUtilities gu=new GeneralUtilities();
  @Test
  public void ManageLocationTestCase() {
	    lp = new LoginPage(driver);
	    ml= new ManageLocation(driver);
		hp=new HomePage(driver);
		lp.sendUserName("admin");
		lp.sendPasswor("admin");
		lp.clickOnSignInButton();
		String actual="Admin";
		String expected=hp.verifyMsg();
		Assert.assertEquals(actual,expected,Constant.lp_verifyLogInWithInValidData);
		ml.ManageMoreInfo();
		ml.CountryStateDropDown();
		ml.LocationDetails();
		ml.DeliveryCharge();
		ml.SaveButton();
		String actual1=ml.AlerMsg();
		String expected1="Alert!";
		Assert.assertEquals(actual1,expected1,Constant.lp_verifyLogInWithInValidData);
		ml.BackToManageLocation();
		String actual2="Kochi"+gu.generateCurrentDateAndTime();
		String expected2=ml.FirstLoaction();
		Assert.assertEquals(actual2,expected2,Constant.lp_verifyLogInWithInValidData);
		
  }
}
