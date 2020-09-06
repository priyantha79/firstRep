package com.TESTNGScripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadDataFromExcel {
	// this works for.xls only

	// @Dataprovider--will provide data from the excel
	// this method need to return value cannot be vouid give obj[][] as to read rows
	// n colums

	// jxl has some jar file has some classes and methods to read from excel so need
	// to add this dependency in pom.xml
	/*
	 * we will make use of a class File from java--import this package syntax
	 * 
	 * @Dataprovider(name="inputdata")--give ant unique name the3n useb @Test(
	 * DataProvider="name of bthe data provider to be used(like above inputdata)")--
	 * so the method knows which dataprovider to get if there are multiple
	 * dataprovider methods if you want the data provider to be used in diff class
	 * make it static you can give multiple parametrs using ,
	 * 
	 * @Test(dataprovider="inputdata(any unique name provided to data provider)"
	 * ,priority='1')) public Object[][] readExcel()--need to give Object[][]n as it
	 * can store many obj so return type has to be Object[][] {
	 * 
	 * File f=new("provide location of excel file"); fetch the exceln from above
	 * provided and store in object--using the getWorkbook() method Workbook
	 * w=Workbook.getWorkbook();//storing in workbook obj
	 * 
	 * now fetch the sheet from workbook--using Sheet class using get sheet method
	 * 
	 * Sheet s=w.getSheet("sheetname");--storing in sheet obj fetch number of rows
	 * which has data int rows=s.getRows();---will fetch number of rows in sheet s
	 * and returns integer so storing in int int col=s.getColumns();
	 * 
	 * now got o row 1 col1 fetch and again row 1 col 2 so on then row 2 ol1 ,row2
	 * col2etc store in array--which nwill store data from row and col String
	 * inputdata[][]=new String[rows][col]; forloop for each row for(int
	 * i=0;i<rows;i++) {
	 * 
	 * loop to read col for(int j=0;j<col;J++) { to fetch cell data we have direct
	 * method getCell(col,row) and store it in Cell obj using getContents method
	 * reads the contents in the cell Cell c=s.getCell(j,i);
	 * inputdata[i][j]=c.getContents();
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * } return inputdata; }
	 */
	static WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
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
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page&campaign=loginCTA");
		
		

	}

	@Test(dataProvider = "inputdata")
	public  void wikipagedata(String name, String password, String retype, String email) throws InterruptedException
	{
		driver.findElement(By.id("wpName2")).clear();
		
		driver.findElement(By.id("wpName2")).sendKeys(name);
		
		//Thread.sleep(2000);
		driver.findElement(By.id("wpPassword2")).clear();
		driver.findElement(By.id("wpPassword2")).sendKeys(password);
		//Thread.sleep(2000);
		driver.findElement(By.id("wpRetype")).clear();
		driver.findElement(By.id("wpRetype")).sendKeys(retype);
		//Thread.sleep(2000);
		driver.findElement(By.id("wpEmail")).clear();
		driver.findElement(By.id("wpEmail")).sendKeys(email);
		//Thread.sleep(2000);
	}

	

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	@DataProvider(name = "inputdata")
	public Object[][] readXls() throws BiffException, IOException {

		File f = new File("C:\\Users\\Mahin\\Desktop\\inputdata2.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet1");
		int rows = s.getRows();
		int col = s.getColumns();
		String inputData[][] = new String[rows][col];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++)

			{
				Cell c = s.getCell(j, i);

				inputData[i][j] = c.getContents();

			}
		}

		return inputData;

	}

}
