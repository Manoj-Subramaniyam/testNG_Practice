package testNG;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class TestCase_1_Window extends ProjectSpecificClass{
	
	@Test
	public void windowHandles() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='Browser']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Window']")).click();
		String currentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//h5[text()='Click and Confirm new Window Opens']/following-sibling::button"))
				.click();
		Set<String> numOfWindows = driver.getWindowHandles();
		List<String> numOfWindowsList = new ArrayList<String>(numOfWindows);
		// System.out.println(numOfWindowsList.get(1));
		driver.switchTo().window(numOfWindowsList.get(1));
		driver.close();
		driver.switchTo().window(currentWindow);
		driver.findElement(By.xpath("//h5[text()='Close all windows except Primary']/following-sibling::button"))
				.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		numOfWindows = driver.getWindowHandles();
		numOfWindowsList = new ArrayList<String>(numOfWindows);
		
		for (String window : numOfWindowsList) {
			if (!window.equals(currentWindow)) {
				driver.switchTo().window(window);
					driver.close();
				
			}
			
		}
		driver.switchTo().window(currentWindow);
		
	}
	
	
}
