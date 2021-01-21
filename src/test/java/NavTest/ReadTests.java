package NavTest;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ReadTests {
  private WebDriver driver;

  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // set driver path
    driver = new ChromeDriver();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void ReggaePlaylist() {
	  
    driver.get("http://localhost:8082/");
    driver.manage().window().setSize(new Dimension(1039, 1112));
    driver.findElement(By.linkText("Reggae")).click();
    assertEquals("Choonz Playlist", driver.getTitle());
    driver.findElement(By.linkText("One Love"));
    
  }
  @Test
  public void RockPlaylist() {
	  
    driver.get("http://localhost:8082/");
    driver.manage().window().setSize(new Dimension(1039, 1112));
    driver.findElement(By.linkText("Rock")).click();
    assertEquals("Choonz Playlist", driver.getTitle());
    driver.findElement(By.linkText("One Love"));
    
  }
  @Test
  public void PopPlaylist() {
	  
    driver.get("http://localhost:8082/");
    driver.manage().window().setSize(new Dimension(1039, 1112));
    driver.findElement(By.linkText("Pop")).click();
    assertEquals("Choonz Playlist", driver.getTitle());
    driver.findElement(By.linkText("One Love"));
    
  }
}
