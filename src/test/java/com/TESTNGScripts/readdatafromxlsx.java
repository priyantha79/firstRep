package com.TESTNGScripts;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import jxl.Cell;




public class readdatafromxlsx {

	
	
	//we cannot use jxl for .xlsx (later versionsm on excel)so we use another jar file called Apache POI jar files
	//we use same method as jxl but different classes and methods
	//we are going to use @Dataprovider annotation
	//add Apache POI dependency in pom.xml
	//we need to add two dependencies--versions of both should be same
	//poi dependency
	//poi-ooxml dependency
	//@Dataprovider(name="any unique name")
	/*public Object[][] readexcel()
	 * {
	 * 
	 * provide excel path
	 * FileInputStream f=FileInputStream("path of excel");
	 *fetch the Workbook location from above
	 
	 * Workbook book=WorkbookFactory.create(f);//import from apache not from jxl
	 * fetch the sheet which has data using class getsheet method
	 * Sheet s=book.getSheet("Sheet name");import from apache poi ss model--imp to remember
	 *fetch the brows and columns
	 *int rows=s.getLastRowNum()
	 *in apache we do not have direct method to get columns
	  * we use  s.getRow(index of first row that is zero/or the row that has all cell values in columns).getLastCell();
	  * int col=s.getRow(0).getLastCellNum();
	  * String input[][]=
	  * for(int i=0;i<rows;i++)
	  * {
	  * for(int j=0;j<rows;j++)
	 * {
	 * input[i][j]=s.getRow(i).getCell(j).toString();
	 * }
	 * }
	 * return input;
	 * 
	 * Usually testers use maaintain a pacakage usually named as utility package and craeate a static class method of dataprovider.
	 * call in the calling class method by providing classsname.methodname and use return statement.
	 * 
	 * 
	 * 
	 * */
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

	@Test(dataProvider="readdata")
	
	
		public  void wikipagedata(String name, String password, String retype, String email) throws InterruptedException ,NullPointerException
	{

		driver.findElement(By.id("wpName2")).clear();
		
		driver.findElement(By.id("wpName2")).sendKeys(name);
		
		Thread.sleep(2000);
		driver.findElement(By.id("wpPassword2")).clear();
		driver.findElement(By.id("wpPassword2")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("wpRetype")).clear();
		driver.findElement(By.id("wpRetype")).sendKeys(retype);
		Thread.sleep(2000);
		driver.findElement(By.id("wpEmail")).clear();
		driver.findElement(By.id("wpEmail")).sendKeys(email);
		
	
}

	

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	
	@DataProvider(name="readdata")
	public Object[][] readxlsx() throws  IOException
	{
		File fe=new File("C:\\Users\\Mahin\\Desktop\\readexcel11.xlsx");
	 FileInputStream f=null;
	 f=new FileInputStream(fe);
	 Workbook wb=WorkbookFactory.create(f);
	 Sheet s=wb.getSheet("Sheet1");
	 int rows=s.getLastRowNum()+1;
	 int col=s.getRow(0).getLastCellNum();
	 System.out.println(rows);
	 System.out.println(col);

	 String inputData[][]=new String[rows][col];
	 for (int i = 0; i < rows; i++) {
			for (int j = 0; j <col; j++)

			{
				inputData[i][j]=s.getRow(i).getCell(j).toString();
				

			}
		}

		return inputData;
		
		
	}
	
	
	
 }


