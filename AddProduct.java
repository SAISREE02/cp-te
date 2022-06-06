package testCases;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class AddProduct {
	public String baseUrl = ("http://localhost:4200/products");
	WebDriver driver;
	String testName;

	@BeforeTest
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		testName="login";
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

	@Test(priority = 2)
	public void addProduct() {
		testName="addProduct";
		System.out.println("Add Products");
		// Click AddProduct Button
		driver.findElement(By.xpath("//button[normalize-space()='Add Product']")).click();
		// Add new Product info
		// Name
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("masala");
		// Description
		driver.findElement(By.xpath("//input[@name='description']")).sendKeys(
				"These spice blends are very similar and make great substitutes for one another when necessary");
		// Price
		driver.findElement(By.xpath("//input[@name='price']")).sendKeys("50");
		// Image Url
		driver.findElement(By.xpath("//input[@name='imageUrl']"))
				.sendKeys("https://t4.ftcdn.net/jpg/02/97/69/65/360_F_297696576_s8k3pGepliFhN2oILIzLUAkQuukKalDI.jpg");
		// Cuisine
		WebElement testdropdown = driver.findElement(By.xpath("//select[@name='selectedCuisine']"));
		Select dropdown = new Select(testdropdown);
		dropdown.selectByIndex(3);

		// Click on add button
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

	}
	@AfterMethod
	public void takeScreenshot() throws Exception {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\kumahar02\\eclipse-workspace\\sample\\target\\screenshots\\"+testName+".png"));
	}

	@AfterTest
	public void afterMethod() throws Exception {
		// driver.quit();
	}

}
