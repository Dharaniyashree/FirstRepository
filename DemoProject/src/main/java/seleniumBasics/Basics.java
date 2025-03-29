package seleniumBasics;
import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.Random;

import javax.swing.JApplet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Basics {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		Random rand = new Random();
		int num = rand.nextInt(3) + 1 ; 
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// checking checkbox 
		String locator = "//label["+num+"]//input[@type='checkbox']";
		String option = driver.findElement(By.xpath(locator)).getAttribute("value");
		driver.findElement(By.xpath(locator)).click();
		Assert.assertTrue(driver.findElement(By.xpath(locator)).isSelected());
		System.out.println("Total number of options are: "+driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		System.out.println("Locator is: "+ locator +" and option selected is: "+ option);
		
		// Static dropdown
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue(option);
		
		// Alert
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		Assert.assertTrue(driver.switchTo().alert().getText().contains(option));
		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		
		// Forms
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Tina");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("tina123@test.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Tina@123Pass");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(dropDown);
		gender.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01-01-2002");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
		Thread.sleep(3000);
		

		// Autosuggestive dropdown
		String country = "India";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys(country.substring(0,3));
		Thread.sleep(3000);
		List <WebElement> optionsShown = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div[class='ui-menu-item-wrapper']"));
		for(WebElement ele : optionsShown) {
			System.out.println(ele.getText());
			if(ele.getText().equals(country)) {
				ele.click();
			}
		}
		
		driver.findElement(By.id("autocomplete")).clear();
		driver.findElement(By.id("autocomplete")).sendKeys(country);
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER));
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']//tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']//tr[2]//td"));
		System.out.println("Number of rows: "+ rows.size());
		System.out.println("Number of columns: "+ columns.size());
		for(int i=0; i<columns.size(); i++) {
			System.out.print(table.findElements(By.xpath("//table[@name='courses']//tr//th")).get(i).getText());
			System.out.println(" : "+table.findElements(By.xpath("//table[@name='courses']//tr[3]//td")).get(i).getText());
		}
		
		driver.quit();
		
		
		
		
	}

}
