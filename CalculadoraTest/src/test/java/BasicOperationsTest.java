// Generated by Selenium IDE
import io.github.bonigarcia.wdm.ChromeDriverManager;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all tests to be performed to calculadora.org.
 */
public class BasicOperationsTest {
  private WebDriver driver;
  private CalculadoraPage calculadoraPage;

  @Before
  public void setUp() {
    ChromeDriverManager.getInstance().version("76.0.3809.126").setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = new ChromeDriver(chromeOptions);
    PageFactory.initElements(driver, this);
    driver.get("https://www.calculadora.org/");
    driver.manage().window().maximize();
    calculadoraPage = new CalculadoraPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void basicOperations_addition() {
    calculadoraPage.operation(1, 2, Operations.ADD);
    assertThat(calculadoraPage.getResult(), is("3"));
  }

  @Test
  public void basicOperations_addition_moreThan1Digit() {
    calculadoraPage.operation(123, 275, Operations.ADD);
    assertThat(calculadoraPage.getResult(), is("398"));
  }

  @Test
  public void basicOperations_subtraction() {
    calculadoraPage.operation(2, 1, Operations.SUBTRACT);
    assertThat(calculadoraPage.getResult(), is("1"));
  }

  @Test
  public void basicOperations_multiplication() {
    calculadoraPage.operation(2, 3, Operations.MULTIPLY);
    assertThat(calculadoraPage.getResult(), is("6"));
  }

  @Test
  public void basicOperations_division() {
    calculadoraPage.operation(9, 3, Operations.DIVIDE);
    assertThat(calculadoraPage.getResult(), is("3"));
  }

  @Test
  public void basicOperations_addition_floatNumbers() {
    calculadoraPage.operation(9.1, 3.2, Operations.ADD);
    assertThat(calculadoraPage.getResult(), is("12.3"));
  }

  @Test
  public void basicOperations_division_infinity() {
    calculadoraPage.operation(1, 0, Operations.DIVIDE);
    assertThat(calculadoraPage.getResult(), is("Infinity"));
  }

  @Test
  public void basicOperations_division_zero() {
    calculadoraPage.operation(0, 2, Operations.DIVIDE);
    assertThat(calculadoraPage.getResult(), is("0"));
  }

  @Test
  public void basicOperations_division_NaN() {
    calculadoraPage.operation(0, 0, Operations.DIVIDE);
    assertThat(calculadoraPage.getResult(), is("NaN"));
  }
}
