package seleniumBasics;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Basics2 {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.manage().window().maximize();
		driver.navigate().back();
		
	//	driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/frames']")).click();
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset/frame")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset/frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
		
		driver.quit();

	}

}
