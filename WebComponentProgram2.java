package SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebComponentProgram2 {

	public static void main(String[] args) throws InterruptedException {

	    // Set up ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// 1. Launch the GUVI website
        driver.get("https://www.guvi.in");
        
        // 2. Locate the "Sign Up" button and click on it
        WebElement signUpButton = driver.findElement(By.xpath(("//a[contains(text(),'Sign up')]")));
         Actions action = new Actions(driver);
 		action.moveToElement(signUpButton).click().build().perform();
 		
 	    // 3. Fill in the sign-up form with required details
   
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameField.sendKeys("Test User");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("testuser61@example.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SecurePassword123");
        
        WebElement mobileNumber = driver.findElement(By.id("mobileNumber"));
        mobileNumber.sendKeys("9876545245");
        
        // 4. Click the "Sign Up" button to submit the form
        WebElement submitSignUpButton = driver.findElement(By.id("signup-btn"));
        submitSignUpButton.click();
        System.out.println("Login successfull");
        Thread.sleep(3000);
        
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.guvi.in");
        
        
        // 6. Locate the "Login" button and click on it
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click();

        // 7. Fill in the login form with the email and password used during registration
        WebElement loginEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        loginEmailField.sendKeys("testuser61@example.com");

        WebElement loginPasswordField = driver.findElement(By.id("password"));
        loginPasswordField.sendKeys("SecurePassword123");

        // 8. Click the "Login" button to submit the form
        WebElement submitLoginButton = driver.findElement(By.id("mobile-login"));
        submitLoginButton.click();
       System.out.println("Login successfull");
     
        driver.close();
    
        
}
}
