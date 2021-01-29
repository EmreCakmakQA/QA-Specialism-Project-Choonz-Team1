package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInTesting {

	  private WebDriver driver;

	  @BeforeEach
	  public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // set driver path
	    driver = new ChromeDriver();
	    driver.manage().window().setSize(new Dimension(1366, 768));
	    driver.get("http://localhost:8082/html/form.html");
	  }
	  
	  
	  @AfterEach
	  public void tearDown() {
	    driver.close();
	  }
	  
	  @Test
	  public void testHome() throws InterruptedException {
	      WebDriverWait wait = new WebDriverWait(driver,30);
	      wait.until(ExpectedConditions.titleIs("Choonz Playlist"));
	      assertEquals("Choonz Playlist", driver.getTitle());
	      String uName = "JohnSmith";
	      driver.findElement(By.id("username")).sendKeys(uName);
	      String pWord = "passwordJS";
	      driver.findElement(By.id("password")).sendKeys(pWord);
	      WebElement submitButton = driver.findElement(By.id("btn"));
	      submitButton.submit();
	      WebDriverWait wait2 = new WebDriverWait(driver,30);
	      wait2.until(ExpectedConditions.titleIs("Choonz Secret Music"));
	      assertEquals("Choonz Secret Music", driver.getTitle());

	  }
	
}
