// Generated by Selenium IDE
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
public class BasicOperationsTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    ChromeDriverManager.getInstance().version("76.0.3809.132").setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = new ChromeDriver(chromeOptions);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    PageFactory.initElements(driver, this);
  }

  @FindBy(name = "expr")
  WebElement resultTextBox;

  @After
  public void tearDown() {
    driver.quit();
  }

  public String getResult() {
    return resultTextBox.getAttribute("value");
  }

  public void pressKey(String key) {
    driver.findElement(By.linkText(key)).click();
  }

  public void operation(String number1, String number2, String operation) {
    pressKey("C");
    pressKey(number1);
    pressKey(operation);
    pressKey(number2);
    pressKey("=");
  }

  @Test
  public void basicOperations() {
    driver.get("https://www.calculadora.org/");
    driver.manage().window().setSize(new Dimension(1054, 808));
    {
      WebElement element = driver.findElement(By.linkText("·"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    operation("1", "2", "+");
    {
      String value = getResult();
      assertThat(value, is("3"));
    }
    operation("2", "1", "-");
    {
      String value = getResult();
      assertThat(value, is("1"));
    }
   operation("2", "3", "×");
    {
      String value = getResult();
      assertThat(value, is("6"));
    }
    operation("3", "2", "×");
    {
      String value = getResult();
      assertThat(value, is("6"));
    }
    operation("9", "3", "÷");
    {
      String value = getResult();
      assertThat(value, is("3"));
    }
    operation("6", "2", "÷");
    {
      String value = getResult();
      assertThat(value, is("3"));
    }
  }
}
