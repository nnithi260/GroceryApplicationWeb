package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant1.Constant;
import elementRepository.AdminUsers;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class AdminUsersTest extends baseClass {
	LoginPage lp;
	HomePage hp;
	AdminUsers adu;
	GeneralUtilities gu=new GeneralUtilities();
  @Test
  public void AdminUserTestCase() throws IOException {
	  lp = new LoginPage(driver);
	  hp = new HomePage(driver);
	  adu= new AdminUsers(driver);
	  lp.sendUserName(ExcelRead.getStringData(1, 1));
	  lp.sendPasswor(ExcelRead.getStringData(2, 1));
	  lp.clickOnSignInButton();
	  String expected = "Admin";
	  String actual = hp.verifyMsg();
	  Assert.assertEquals(actual,expected,Constant.lp_verifyLogInWithInValidData);
	  adu.AdminUserInfo();
	  adu.UserData();
	  adu.UserDropDown();
	  adu.SaveButton();  
	  adu.LogOut();
	  String expected1="Sign in to start your session";
	  String actual1=adu.SignInText(); 
	  Assert.assertEquals(actual1,expected1,Constant.lp_verifyLogInWithInValidData);
	  lp.sendUserName("123"+gu.generateCurrentDateAndTime());
	  lp.sendPasswor("Hi@123");
	  lp.clickOnSignInButton();
	  String expected2 = "123"+gu.generateCurrentDateAndTime();
	  String actual2 = hp.verifyMsg();
	  Assert.assertEquals(actual2,expected2,Constant.lp_verifyLogInWithInValidData);
	  
  }
}
