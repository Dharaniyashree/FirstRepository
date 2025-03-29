import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimplePrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello World");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https:gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dharaniyashree@gmail.com");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		
	}

}
