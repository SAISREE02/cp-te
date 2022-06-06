package testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {
	
public String baseUrl=("http://localhost:4200/products");
	
	WebDriver driver;
	
	String testName;

	
//	@SuppressWarnings("deprecation")
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching Chrome Browser");
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=0)
	public void userRegistration() {
		testName="userRegistration";
		System.out.println("Launching Chrome Browser");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		  //click on Login Button
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-login-status[1]/div[1]/button[1]")).click();
		//create an account
		 driver.findElement(By.xpath("//a[contains(text(),'Create an Account')]")).click();
		 //username
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Jhon");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("jhon@gmail.com");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[3]/input[1]")).sendKeys("Jhon@123");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[4]/input[1]")).sendKeys("9301509048");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[5]/input[1]")).sendKeys("Bangalore");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[6]/input[1]")).sendKeys("Yalhanka");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[7]/input[1]")).sendKeys("560064");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-register[1]/div[1]/form[1]/div[8]/button[1]")).click();
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void userLogin() throws InterruptedException {
		testName="userLogin";
		System.out.println("Launching Chrome Browser");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		 
	//	 WebElement element= driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-login-status[1]/div[1]/button[1]")).click();
		 WebElement element = driver.findElement(By.cssSelector("div.page-wrapper:nth-child(1) div.page-container header.header-desktop:nth-child(1) div.section-content.section-content-p30 div.container-fluid div.header-wrap app-login-status:nth-child(3) div.form-header > button.au-btn-submit.login"));
		 element.click();
		 element.click();
//		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-login-status[1]/div[1]/button[1]")).click();

		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-login[1]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys("2");
		  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-login[1]/div[1]/form[1]/div[1]/div[2]/input[1]")).sendKeys("2");
		// Login Button
			driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
			Thread.sleep(2000);
		
	}
	@SuppressWarnings("deprecation")
	@Test(priority=2)
	public void addtoCart() throws InterruptedException {
		testName="addtoCart";
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		//For All Product
		 WebElement element2 =driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-product-list[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]"));
		 element2.click();
		  Thread.sleep(2000);
		  //Add to cart
		  driver.findElement(By.xpath(" /html[1]/body[1]/app-root[1]/div[1]/div[1]/app-product-details[1]/div[1]/div[1]/button[1]")).click();
		  Thread.sleep(3000);
		  //back to the product list
		  driver.navigate().back();
		  
		  
		  
		  WebElement element4=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-cart-status[1]/div[1]"));
		  element4.click();
		  Thread.sleep(2000);
		  element4.click();
		  element4.click();
		  
		  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-cart-details[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tr[3]/td[2]/a[1]/button[1]")).click();
		  driver.findElement(By.xpath("/html/body/app-root/div/div/app-check-out/div/div/div/a/button")).click();
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=3)
	public void userLogout() {
		testName="userLogout";
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/app-login-status[1]/div[1]/button[1]")).click();
	}
	@AfterMethod
	public void takeScreenshot() throws Exception {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\kumahar02\\eclipse-workspace\\sample\\target\\screenshots\\"+testName+".png"));
	}
}
