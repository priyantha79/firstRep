package com.TESTNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class WikiTestase {

	// In TESTNG the test steps for testcases will be written as methods
	// testNg annotation to execute a testase
	// reate method as testcase
	// all methods will be void for testNg except for datadriven
	// a method used to perform testcase is alled test method
	// if we have to execute a test method,we will user a testNG annotation alled as
	// @test
	// annotation will be written over the test method
	// within one class we an written in same class
	// if the testmethod does not start with @Test it wont be exected
// testng exeutes testcases in alphabetical order--in order to do thid we create priority for executing them in sequene we want by using @Test(priority='1')
	// test reports an be created(results of running class tab after execution
//@BBeforeClass-will get executed  as the first method
	//AfterClass represents the method to be executed at the end opposite to that of BeforeClass
	//public static WebDriver driver;
	//@BeforeMethod and @ AfterMethod --will be executed before and after everymethod
	
	//if no annotation added the compiler would not execute that testmethod
	
	
	
	
	public static WebDriver driver;
	
	
	
@BeforeClass
	//@Test(priority = '1')
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		// open the browser
		// WebDriver is an interface in selenium itb has methods and browser
		// classes==like ChromeDriver class,FFBrowser class
		// methods of Webdriver(Case sensitive) are implemented in browser class like
		// ChromeBrowser or FFBrowsedr
		driver = new ChromeDriver();// will open the browser
		// now open the application on browser using get method--implemented in
		// Chrdriver
		driver.manage().deleteAllCookies();
		// managing the load time

		driver.get(
				"https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page&campaign=loginCTA");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	
	System.out.println("setup method executed");
	}


@Parameters({"Uname","Pname"})
@Test(priority='1')

//@BeforeMethod()
	//@Test(priority = '2')
	public void createAccount(String Uname,String Pname) throws InterruptedException {

		// isDisplayed--output is boolean it checks if the element is displayed or not
		// on the page
		// isEnabled--output is boolean it checks if the element is enabled or not on
		// the page
		
		// boolean dis = driver.findElement(By.id("wpName2")).isDisplayed();
		// boolean enb=driver.findElement(By.id("wpName2")).isEnabled();
	Thread.sleep(2000);
		driver.findElement(By.id("wpName2")).clear();
	
		  driver.findElement(By.id("wpName2")).sendKeys(Uname);
		  Thread.sleep(2000);
		  driver.findElement(By.id("wpName2")).clear(); 
		  Thread.sleep(5000);
		 
		  /// Web element in webapplication is to store the location of the webelement
		  WebElement ele = driver.findElement(By.id("wpPassword2"));
		//  System.out.println(ele.isDisplayed()); 
		//  System.out.println(ele.isEnabled());
		 ele.sendKeys(Pname); 
		 Thread.sleep(3000); 
		// ele.clear();
		
		//System.out.println("created acct method executed");

	}

	//@Test
	public void Mainpage() {

		System.out.println("Main page method executed");

	}
	//@Test
	@AfterClass
	//@Test(priority = '4')
	public void Closebrowser()
	{
				
		driver.close();
		System.out.println("closing browser");
	}

}
