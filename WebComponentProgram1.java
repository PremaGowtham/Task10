package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WebComponentProgram1 {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigate to the URL
		driver.navigate().to("https://jqueryui.com/datepicker/");
		
		//Switch to the iframe that contains the datepicker
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		//Open the datepicker by clicking the input field
		WebElement dateInput = driver.findElement(By.id("datepicker"));
		dateInput.click();
		Thread.sleep(2000);
		
		//Select the next month
		WebElement nextMonthButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
		nextMonthButton.click();
		Thread.sleep(2000);
		
		//Select the date "22"
		WebElement date = driver.findElement(By.xpath("//a[text()='22']"));
		date.click();
		Thread.sleep(1000);
		
		//Get the selected date from the input field and print it
		String selectedDate = dateInput.getAttribute("value");
		System.out.println("Selected Date:" + selectedDate);
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
