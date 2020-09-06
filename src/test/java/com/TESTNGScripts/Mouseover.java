package com.TESTNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mouseover {
	
	//Mouse over
	//Class Actions--this class has methods that will help us to perform mouseover--it is series of events that are performed
	//Methods are moveTo();
	//build,perform
	
	//create obj for Actions class Actions obj=new Actions(driver)
	//obj.moveToElement(e).build().perform();
	//-------------
	//drag and drop can be done using Actions class
	//ex site jqueryui.com/droppable
	//clickAndHold(element)
	//moveTo(element details)
	//build()
	//perform()
	//build and perform are used to perform the series of events in web 
	//------------------------------------------------------------------------------------------------------------------
	//driver.navigate.refresh to refresh the page
	//rightclick--
	//driver.switchto.defaultcontent---switch to default frame
	//obj.contextClick(target element).build.perform method to rightclick
	//for doubleclick use method obj.doubleclick(targetelement).build.perform

	
	//----------KeyEvents
	//ctrl+t to open new tab in browser but in selenium we dont have direct method we can use keyboard to pass any keys to webpage or tabs
	//we make use of Robot Class--its a class in TestNG
	//Robot robot=new Robot
	//robot.keyPress(keyevent.)--KeyEvent class-vk is virtual key
	//robot.keyrelease(keyevent.)
	
	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		
		driver = new ChromeDriver();// will open the browser
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().fullscreen();
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page&campaign=loginCTA");
		
		Thread.sleep(2000);
		

			}
	
	//@Test()
	public void dragDrop() throws InterruptedException
	{
		
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
	WebElement drag=	driver.findElement(By.id("draggable"));
	WebElement drop=	driver.findElement(By.id("droppable"));
	Actions ac=new Actions(driver);
	ac.clickAndHold(drag);
	Thread.sleep(5000);
	ac.moveToElement(drop).build().perform();
	Thread.sleep(5000);

	//driver.close();
		
		
	}
	
	@Test()
	public void rightclick() throws InterruptedException
	{
		driver.navigate().to("https://jqueryui.com/droppable/");

		//driver.navigate().refresh();
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.linkText("Resizable"));
		Actions a=new Actions(driver);
		a.contextClick(e).build().perform();
		Thread.sleep(2000);
		
		
		
	}
	
	
	//capture all tabs that are open on a browser window
	//getWindowHandles()--captures all the tabs
	//ArrayList<String> tabs=new ArrayList<String>(driver.grtWindowHandles());
	//every tab open has an index and you want to open an url in a particular tab
	//driver.switchTo.Window(tabs.get(1));--same to switch tabs
	
	
	
}



