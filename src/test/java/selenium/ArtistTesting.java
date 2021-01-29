package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArtistTesting {

	  private WebDriver driver;

	  @BeforeEach
	  public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // set driver path
	    driver = new ChromeDriver();
	    driver.manage().window().setSize(new Dimension(1366, 768));
	    driver.get("http://localhost:8082/html/artists.html");
	  }
	  
	  
	  @AfterEach
	  public void tearDown() {
	    driver.close();
	  }
	  
	  @Test
	  public void testArtists() throws InterruptedException {
	      driver.findElement(By.id("playlistName")).click();
	      assertEquals(driver.findElement(By.cssSelector(".heading")).getText(), "Artist Name");

	  }
}
