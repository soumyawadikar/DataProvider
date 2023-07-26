package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment4 {

		
			
			 public String url="https://demo.guru99.com/test/login.html";
		String driverpath="C:\\Users\\excel\\Downloads\\chromedriver_win32\\chromedriver.exe\\";
			  WebDriver driver;
			
			
			@BeforeTest
			public void launchbrowser() {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\excel\\Downloads\\chromedriver_win32\\chromedriver.exe\\");
				driver =new ChromeDriver();
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			
				driver.get(url);
			}
			@Test(dataProvider="LoginData")
			public void loginTest(String username,String password) {
				
				driver.findElement(By.id("email")).sendKeys("username");
				driver.findElement(By.id("passwd")).sendKeys("password");;
				driver.findElement(By.id("SubmitLogin")).click();
				
				
			}
			
			@DataProvider(name="LoginData")
			
		public String[][] getData() throws IOException {
				
				String path="D:\\guru99Sheet.xlsx";
				XLUtility xlutil=new XLUtility(path);
				
				 
				int totalrows=xlutil.getRowCount("Sheet1");
				 int totalcols=xlutil.getCellCount("Sheet1", 1);
			
				String loginData[][]=new String[totalrows][totalcols];
				
				for(int r=1;r<=totalrows;r++) {
					for(int c=0;c<totalcols;c++) {
					  loginData[r-1][c]=xlutil.cellData("Sheet1",r,c);
						
					}
				}
				return loginData;
				
				
				
			}
				
					
				
			
				
			@AfterTest
			public void terminatebrowser() {
				driver.close();
			}
			
			
			
			

	}


