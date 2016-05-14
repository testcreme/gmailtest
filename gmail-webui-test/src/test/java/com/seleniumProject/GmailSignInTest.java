package com.seleniumProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GmailSignInTest {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	   @Test
	    public void gmailLoginShouldBeSucessful() {
		   
	        //1. Go to Gmail website
		   
		   driver.get("http://gmail.com");

		 //2. Fill in username
	        WebElement usernameTextbox = driver.findElement(By.xpath(".//*[@id='Email']"));
	        usernameTextbox.clear();
	        usernameTextbox.sendKeys("willokans@gmail.com");

	            //click Next
	            driver.findElement(By.xpath(".//*[@id='next']")).click();

	        //3. Fill in password
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
	        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
	        passwordTextbox.clear();
	        passwordTextbox.sendKeys("Slide2016!");

	        //4. Click sign in
	        WebElement signInButton = driver.findElement(By.xpath(".//*[@id='signIn']"));
	        signInButton.click();

	        //5. verify use did sign in
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
	        Assert.assertTrue("Inbox Should exist",driver.findElements(By.partialLinkText("Inbox")).size()>0);

	        //6. sign out
	        WebElement profileButton = driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span"));
	        profileButton.click();

	        WebElement SignOutButton = driver.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
	        SignOutButton.click();

	        //7. Verify user did sign out
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='signIn']")));
	        Assert.assertTrue("Sing in button Should exist",driver.findElements(By.xpath(".//*[@id='signIn']")).size()>0);


	    }
	   
	   @After
	    public void tearDown()
	    {
	        driver.quit();
	    }

}
