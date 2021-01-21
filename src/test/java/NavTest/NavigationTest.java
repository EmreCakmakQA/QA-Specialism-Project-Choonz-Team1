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
public class NavigationTest {
  private WebDriver driver;

  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // set driver path
    driver = new ChromeDriver();
  }
  @After
  public void tearDown() {
    //driver.quit();
  }
  @Test
  public void navigation() {
	  
    driver.get("http://localhost:8082/");
    driver.manage().window().setSize(new Dimension(1039, 1112));
    driver.findElement(By.linkText("Featured Tracks")).click();
    assertEquals("Choonz Tracks", driver.getTitle());
  }
  @Test
  public void nav2() {
	  
    driver.get("http://localhost:8082/");
    driver.manage().window().setSize(new Dimension(1039, 1112));
    driver.findElement(By.linkText("Artists"));
    assertEquals("Choonz Music", driver.getTitle());	
   
  }
  @Test 
  public void nav3() {
	  
    driver.get("http://localhost:8082/");
    driver.findElement(By.linkText("Top Playlists")).click();
    assertEquals("Choonz Playlists", driver.getTitle());
   
  }
  @Test
  public void nav4() {
	  
	    driver.get("http://localhost:8082/");
	    driver.findElement(By.linkText("Albums")).click();
	    assertEquals("Choonz Albums", driver.getTitle());
	  }
  
}
