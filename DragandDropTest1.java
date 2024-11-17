package SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropTest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// 1. Launch the website
        driver.get("https://jqueryui.com/droppable/");

        Thread.sleep(3000);
            // Switch to the iframe containing the drag-and-drop elements
            driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

            // Locate the source and target elements
            WebElement sourceElement = driver.findElement(By.id("draggable"));
            WebElement targetElement = driver.findElement(By.id("droppable"));

            // Perform the drag-and-drop action
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();

            // Wait for the operation to complete
            Thread.sleep(3000); // Explicit wait to observe the result

            // Verify the background color of the target element
            String backgroundColor = targetElement.getCssValue("background-color");
            System.out.println("Background color after drop: " + backgroundColor);

            // Verify the text of the target element
            String targetText = targetElement.getText();
            System.out.println("Target text after drop: " + targetText);

            // Assertions (Replace with your preferred assertion library)
            if (backgroundColor.contains("rgb") && "Dropped!".equals(targetText)) {
                System.out.println("Drag and drop operation successful.");
            } else {
                System.out.println("Drag and drop operation failed.");
            }
           Thread.sleep(2000);
        
            driver.quit();
        }
    

	}


