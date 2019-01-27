package config;

import static executionEngine.DriverScript.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionKeywords {

	public static WebDriver driver;
	
	public static void openBrowser() {
		WebDriverManager.chromedriver().setup();			
		driver = new ChromeDriver();
		}
	
	public static void navigate() {
		driver.get(Constants.URL);
	}
	
	public static void input_EmployeeCode() {
		driver.findElement(By.id(OR.)).clear();
		driver.findElement(By.id("userid")).sendKeys(Constants.UserId);
	}
	
	public static void input_Password() {
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(Constants.Password);
	}
	
	public static void input_OrgCode() {
		driver.findElement(By.id("organizationcode")).clear();		
		driver.findElement(By.id("organizationcode")).sendKeys(Constants.OrganizationCode);
	}
	
	public static void click_Login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public static void waitFor() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public static void click_Logout() {
		driver.findElement(By.id("logoutbtnid")).click();
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
}





















