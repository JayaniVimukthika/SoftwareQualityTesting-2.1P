package sit707_week2;

import java.io.IOException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//maximize window
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Jayani");
		
		driver.findElement(By.id("lastname")).sendKeys("Vithanage");
		
		WebElement elemengPhone = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + elemengPhone);
		// Send phone number
		elemengPhone.sendKeys("0424113484");
	
		WebElement elementEmail = driver.findElement(By.id("email"));
		System.out.println("Found element: " + elementEmail);
		// Send email address
		elementEmail.sendKeys("jayani@gmail.com");
		
		WebElement elementPassword = driver.findElement(By.id("password"));
		System.out.println("Found element: " + elementPassword);
		// Send password
		elementPassword.sendKeys("Jayani@6");
		
		WebElement elementConfirmPassword = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + elementConfirmPassword);
		// Send email address
		elementConfirmPassword.sendKeys("Jayani@6");
		
		//toggle button selects personal option
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[10]/div/button[1]")).click();
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button")).click();
	
		
		/*
		 * Take screenshot using selenium API.
		 */
		File screenshotAS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotAS, new File(".//images/image1.png"));//screenshot goes to images folder
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
