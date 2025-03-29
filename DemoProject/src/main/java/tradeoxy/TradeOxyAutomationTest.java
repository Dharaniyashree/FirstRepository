package tradeoxy;

import static io.restassured.RestAssured.given;
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

import io.restassured.RestAssured;

public class TradeOxyAutomationTest {
	public static void main(String[] args) throws InterruptedException {

		/*
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tradeoxy.com/");
		
		driver.findElement(By.xpath("//a/button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//*[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testname@test.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123456");
		driver.findElement(By.xpath("//button/span[text()='Sign In']")).click();
		
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("//button/span[text()='Get in touch']")).click();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("testname");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("testname@test.com");
		driver.findElement(By.cssSelector("textarea[name='statement']")).sendKeys("Writting to get to know the information regarding this stock");
		driver.findElement(By.cssSelector("input[name='market']")).sendKeys("NYSE");
		driver.findElement(By.cssSelector("input[name='ticker']")).sendKeys("BTC");
		driver.findElement(By.id("Private")).click();
		driver.findElement(By.xpath("//button/span[text()='Contact us']")).click();
		
		*/
		
		/*
		String h1text;
		driver.findElement(By.xpath("//button/div/p[text()='Crypto']")).click();
		Thread.sleep(2000);
		h1text =  driver.findElement(By.cssSelector("div h1[class*='my-auto']")).getText();
		assertEquals(h1text, "Crypto Scanners");
		
		driver.findElement(By.xpath("//button/div/p[text()='Forex']")).click();
		Thread.sleep(2000);
		h1text =  driver.findElement(By.cssSelector("div h1[class*='my-auto']")).getText();
		assertEquals(h1text, "Forex Scanners");
		
		driver.findElement(By.xpath("//button/div/p[text()='Stocks']")).click();
		Thread.sleep(2000);
		h1text =  driver.findElement(By.cssSelector("div h1[class*='my-auto']")).getText();
		assertEquals(h1text, "Stocks Scanners");
		
		String clickText = "5 min Intraday";
		driver.findElement(By.xpath("//*[text()='"+clickText+"']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("section"))));
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//header/div/h1")).getText());
		String title = driver.findElement(By.xpath("//header/div/h1")).getText();
		assertEquals(title, clickText);
		String info = driver.findElement(By.xpath("//section/div/div/div[@class='text-white text-lg font-medium']")).getText();
		assertEquals(info, "No stocks filtered in the Scan");
		
		driver.findElement(By.xpath("//div/a/img")).click();
		
		driver.findElement(By.linkText("Pricing")).click();
		assertTrue(driver.getCurrentUrl().contains("pricing"));
		driver.findElement(By.xpath("//section/div/form/div/button[@role='switch']")).click();
		
		
		driver.findElement(By.linkText("Roadmap")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWinId = it.next();
		String childWinId = it.next();
		driver.switchTo().window(childWinId);
		assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Roadmap"));
		driver.switchTo().window(parentWinId);
		assertEquals(driver.getCurrentUrl(), "https://tradeoxy.com/");
		*/
		
		RestAssured.baseURI = "https://api2.amplitude.com/2/httpapi";
		String response = given().header("Content-Type", "application/json").log().all()
				.body("{\r\n"
						+ "    \"api_key\": \"1c1790ac958c8df7046d0e2e978280b\",\r\n"
						+ "    \"events\": [\r\n"
						+ "        {\r\n"
						+ "            \"device_id\": \"2929c9b1-611a-41ce-8b89-e120f48adc81\",\r\n"
						+ "            \"session_id\": 1732455649600,\r\n"
						+ "            \"time\": 1732455926942,\r\n"
						+ "            \"platform\": \"Web\",\r\n"
						+ "            \"language\": \"en-US\",\r\n"
						+ "            \"ip\": \"$remote\",\r\n"
						+ "            \"insert_id\": \"e3a5c26e-9e98-447b-bd44-4c297de57c28\",\r\n"
						+ "            \"event_type\": \"[Amplitude] Page Viewed\",\r\n"
						+ "            \"event_properties\": {\r\n"
						+ "                \"[Amplitude] Page Domain\": \"tradeoxy.com\",\r\n"
						+ "                \"[Amplitude] Page Location\": \"https://tradeoxy.com/\",\r\n"
						+ "                \"[Amplitude] Page Path\": \"/\",\r\n"
						+ "                \"[Amplitude] Page Title\": \"15 min Breakout\",\r\n"
						+ "                \"[Amplitude] Page URL\": \"https://tradeoxy.com/\"\r\n"
						+ "            },\r\n"
						+ "            \"event_id\": 116,\r\n"
						+ "            \"library\": \"amplitude-ts-gtm/3.7.1\",\r\n"
						+ "            \"user_agent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0\"\r\n"
						+ "        }\r\n"
						+ "    ],\r\n"
						+ "    \"options\": {}\r\n"
						+ "}")
				.when().post().then().log().all().assertThat().statusCode(200).extract().asString();
		
		}
}
