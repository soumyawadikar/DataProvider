package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment3 {
	
	 
	 public String url="https://demoqa.com/";
//String driverpath="C:\\Users\\excel\\Downloads\\chromedriver_win32\\chromedriver.exe\\";
	  WebDriver driver;
	
	@BeforeGroups({"Smoke","regression"})
	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\excel\\Downloads\\chromedriver_win32\\chromedriver.exe\\");
		driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		driver.get(url);
	}
	
	
	@Test(groups= {"Smoke"})
	public void clickOnForms()
	{
		
		driver.findElement(By.xpath("//div[@class=\"category-cards\"]/div[2]")).click();
		System.out.println("smoke");
		
	}
	

	@Test(groups= {"Smoke"})
	public void clickOnPractice()
	{
		
		driver.findElement(By.xpath("//span[text()=\"Practice Form\"]")).click();
		
		
		
		
	}
	
	
	@Test(groups= {"regression"})
	public void enterData()
	
	{
		driver.findElement(By.xpath("//div[@class=\"category-cards\"]/div[2]")).click();
		driver.findElement(By.xpath("//span[text()=\"Practice Form\"]")).click();
	   //System.out.println("regression testing");
	
		driver.findElement(By.id("firstName")).sendKeys("abc");
		driver.findElement(By.id("userEmail")).sendKeys("sam@gmail.com");
		driver.findElement(By.xpath("//div[@class=\"col-md-9 col-sm-12\"]/div[2]//label[text()=\"Female\"]")).click();
		
		
		
	}
	
	@AfterTest
	public void terminatebrowser() {
		driver.close();
	}
	
	
	
	
	
	
	
}
