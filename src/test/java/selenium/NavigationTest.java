package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavigationTest {
	
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // set driver path
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(1366, 768));
    driver.get("http://localhost:8082");
  }
  
  @Test
  public void testHome() throws InterruptedException {
      
      assertEquals("Choonz Music", driver.getTitle());
  }
  
  @Test
  public void testTracks() throws InterruptedException {
      WebElement trackMenu = driver.findElement(By.linkText("Featured Tracks"));
      trackMenu.click();
      assertEquals("Choonz Tracks", driver.getTitle());

  }
  
  @Test
  public void testArtists() throws InterruptedException {
      WebElement artistMenu = driver.findElement(By.linkText("Artists"));
      artistMenu.click();
      assertEquals("Choonz Artists", driver.getTitle());

  }
  
  
  @Test
  public void testAlbums() throws InterruptedException {
      WebElement albumMenu = driver.findElement(By.linkText("Albums"));
      albumMenu.click();
      assertEquals("Choonz Albums", driver.getTitle());

  }
  
  @AfterEach
  public void tearDown() {
    driver.close();
  }

  
}
