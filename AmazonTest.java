package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {
    
	WebDriver driver = null;
	
	@BeforeMethod
	public void setupAmazonTest(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://amazon.com");
	}
	@Test
	public void verifyAmazonTest(){
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		System.out.println("Bye");
	}
	@Test
	public void searchAmazonTest(){
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"))).build().perform();
		driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/span[7]/span")).click();
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
	}
	@Test
	public void signInAmazonTest(){
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']/span[2]"))).build().perform();
		driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span")).click();
		String text = driver.findElement(By.xpath("//*[@id='a-page']/div[1]/div[1]/div/a/i")).getText();
		Assert.assertEquals(text,"Amazon");
		System.out.println(text);
	}
	@Test
	public void createAmazonAccountTest(){
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']/span[2]"))).build().perform();
		driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span")).click();
		driver.findElement(By.xpath("//*[@id='createAccountSubmit']")).click();
		String text2 = driver.findElement(By.xpath("//*[@id='ap_register_form']/div/div/h1")).getText();
		Assert.assertEquals(text2,"Create account");
		System.out.println(text2);
		driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys("Seema");
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("seema.pal01@gmail.com");
		//driver.findElement(By.xpath("//*[@id='ap_email_check']")).sendKeys("seema.pal01@gmail.com");
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("P@ssw0rd@123");
		driver.findElement(By.xpath("//*[@id='ap_password_check']")).sendKeys("P@ssw0rd@123");
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		System.out.println("the account has been created");
	}
	@AfterMethod
	public void tearDownAmazon(){
		driver.quit();
	}
}
