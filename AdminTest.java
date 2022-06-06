package testCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminTest {
	
	public String baseUrl=("http://localhost:4200/products");
			
			public WebDriver driver;
			String testName;

			
//			@SuppressWarnings("deprecation")
			@BeforeTest
			public void launchBrowser() {
				System.out.println("Launching Chrome Browser");
				WebDriverManager.chromedriver().setup();
			    driver=new ChromeDriver();
			    driver.manage().window().maximize();
			    driver.get(baseUrl);
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			
			@SuppressWarnings("deprecation")
			@Test(priority=1)
			public void adminlogin() throws Exception {
				testName="adminlogin";
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

				driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin");

				// Login Button
				driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
				Thread.sleep(2000);
				
				Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Welecome admin.");
			
				
		 }
			
			@SuppressWarnings("deprecation")
			@Test(priority=2)
			public void serachProduct() {
				testName="serachProduct";
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
				//SearchProduct
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-search[1]/div[1]/input[1]")).sendKeys("Moutabal");
				//click on search button
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-search[1]/div[1]/button[1]")).click();
				
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-search[1]/div[1]/input[1]")).clear();
		
				
			}
			@SuppressWarnings("deprecation")
			@Test(priority=3)
			public void allProduct() {
				testName="allProduct";
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
				//For All Product
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/aside[1]/app-product-category-menu[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]")).click();
				//Shorting by name
				WebElement testdropdown = driver.findElement(By.xpath("//body[1]/app-root[1]/div[1]/div[1]/app-product-list[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/select[1]"));  
				Select dropdown = new Select(testdropdown);  
				dropdown.selectByIndex(0); 
				
				//Shorting by firstcreated
				WebElement testdropdown1 = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-product-list[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/select[1]"));  
				Select dropdown1 = new Select(testdropdown1);  
				dropdown1.selectByIndex(1);
				
				//Shorting by Lastcreated
				WebElement testdropdown2 = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-product-list[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/select[1]"));  
				Select dropdown2 = new Select(testdropdown2);  
				dropdown2.selectByIndex(2);
				
				//For All Arab Arab
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/aside[1]/app-product-category-menu[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
				//For All chinese product
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/aside[1]/app-product-category-menu[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]")).click();
				//For All Arab Presian
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/aside[1]/app-product-category-menu[1]/div[1]/nav[1]/ul[1]/li[5]/a[1]")).click();
				//For All Arab Indian
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/aside[1]/app-product-category-menu[1]/div[1]/nav[1]/ul[1]/li[6]/a[1]")).click();
				//For All Arab Italian
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/aside[1]/app-product-category-menu[1]/div[1]/nav[1]/ul[1]/li[7]/a[1]")).click();
				
			}
			
			@SuppressWarnings("deprecation")
			@Test(priority=4)
			public void logout() {
				testName="logout";
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-login-status[1]/div[1]/button[1]")).click();
								
			}
			
			
			@AfterMethod
			public void takeScreenshot() throws Exception {
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("C:\\Users\\kumahar02\\eclipse-workspace\\sample\\target\\screenshots\\"+testName+".png"));
			}
			


}
