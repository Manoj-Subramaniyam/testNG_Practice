package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_2_Waits extends ProjectSpecificClass {
	
	@Test
	public void waits() {
		
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Waits']")).click();
		// Visibility of element
		driver.findElement(By.xpath("//h5[contains(text(),'Wait for Visibility')]/following::button[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'I am here')]")));

		if (driver.findElement(By.xpath("//*[contains(text(),'I am here')]")).isDisplayed())
			System.out.println("element is Visible");
		
	}
}
