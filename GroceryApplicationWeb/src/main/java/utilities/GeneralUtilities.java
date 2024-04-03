package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept(); 
	}
	public void selectDropDownUsingIndex(WebElement element,int index) {
		Select object=new Select(element);  // to call dropdown we use select class
		object.selectByIndex(index);
	}
	public void sendValueUsingJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);   //instead of send keys
	}
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;                    //to select random values
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmm");   //to generate current values
		return formatter.format(date);
	}
	public void click(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;            
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	public void scroll(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,5000)");
	}
}
