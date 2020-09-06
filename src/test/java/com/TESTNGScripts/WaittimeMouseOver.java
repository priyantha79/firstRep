package com.TESTNGScripts;

public class WaittimeMouseOver {

	//Thread.sleep is static wait because after specified time is done even the element is visible
	//adding wait times increases the run time
	
	
	//Implicit wait,Fluent wait,explicit wait
	//fluent will be depreciated by selenium
	/*
	 * 
	 * 
	 * 
	 * 
	 * selenium provides us with wait methods for synchronization
	 *explicit wait--you will give time to wait and when toolm is waiting give condition like if the elemnt is visible in less than the specified it will not wait for extra time by saving the time
	 *explicit wait will be applied to one particular element
	 *
	 *We have WebDriverWait class
	 *WebDriverWait w=new WebDriverWait(driver,10)
	 *condition as below
	 *w.until(ExpectedConditions.visibilityOf(element))---Expected contions is a class and .method name and element is the webelement
	 *implicit wait
	// driver.manage().timeouts.implicitlyWait(3,TimeUnit.Seconds)==generally given after invoking the url
	//Pageloadtimeout
	 * driver.manage().timeouts().pageLoadTimeOut(3,TimeUnit.SECONDS)
	
	*/
	
}
