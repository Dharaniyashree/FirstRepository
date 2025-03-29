package tradeoxy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TradeOxyUIAutomation {
	
	private WebDriver driver;
	private String home = "https://tradeoxy.com/";
	private WebDriverWait wait;
	
	@BeforeMethod
	void setUp() {
		// initial setup
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(home);
	}
	
	@Test
	void testSignIn() {
		// sign in form check
		driver.findElement(By.xpath("//a/button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//*[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testname");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		driver.findElement(By.xpath("//button/span[text()='Sign In']")).click();
	}
	
	@Test
	void testGetinTouch() {
		// get in touch form check
		driver.findElement(By.xpath("//button/span[text()='Get in touch']")).click();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("testname");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("testname@test.com");
		driver.findElement(By.cssSelector("textarea[name='statement']")).sendKeys("Writting to get to know the information regarding this stock");
		driver.findElement(By.cssSelector("input[name='market']")).sendKeys("NYSE");
		driver.findElement(By.cssSelector("input[name='ticker']")).sendKeys("BTC");
		driver.findElement(By.id("Private")).click();
		driver.findElement(By.xpath("//button/span[text()='Contact us']")).click();
	}
	
	@Test
	void testNavigationAndH1() throws InterruptedException {
		// checking each options using loop
		String h1text[] =  {"Crypto","Forex","Stocks"};
		for(String text : h1text) {
			driver.findElement(By.xpath("//button/div/p[text()='"+text+"']")).click();
			Thread.sleep(2000);
			assertEquals( driver.findElement(By.cssSelector("div h1[class*='my-auto']")).getText(), text+" Scanners");
		}
		
	}
	
	@Test 
	void testCardActivity() throws InterruptedException {
		// checking the activity click and loading
		String clickText = "5 min Intraday";
		driver.findElement(By.xpath("//*[text()='"+clickText+"']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("section"))));
		Thread.sleep(2000);
		String title = driver.findElement(By.xpath("//header/div/h1")).getText();
		assertEquals(title, clickText);
		String info = driver.findElement(By.xpath("//section/div/div/div[@class='text-white text-lg font-medium']")).getText();
		assertEquals(info, "No stocks filtered in the Scan");
	}
	
	@Test
	void testPricing() {
		// navigating to pricing tab and toggling the monthly annualy option
		driver.findElement(By.linkText("Pricing")).click();
		driver.findElement(By.xpath("//section/div/form/div/button[@role='switch']")).click();
		assertTrue(driver.getCurrentUrl().contains("pricing"));
	}
	
	@Test
	void testGetHome() {
		// getting back to home screen with tradeoxy img icon in pricing tab
		driver.findElement(By.linkText("Pricing")).click();
		driver.findElement(By.xpath("//div/a/img")).click();
		assertEquals(driver.getCurrentUrl(),home);
	}
	
	@Test
	void testRoadmap() {
		// navigating to roadmap child tab and returning to home
		driver.findElement(By.linkText("Roadmap")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWinId = it.next();
		String childWinId = it.next();
		driver.switchTo().window(childWinId);
		assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Roadmap"));
		driver.switchTo().window(parentWinId);
		assertEquals(driver.getCurrentUrl(), home);
		
	}
	
	@AfterMethod
	void tearDown() {
		// closing the window
		driver.quit();
	}

}
