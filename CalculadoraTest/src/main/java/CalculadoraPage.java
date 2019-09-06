import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class which has all basic functions of calculadora.org
 */
public class CalculadoraPage {
    private WebDriver driver;
    private OperatorSymbol operatorSymbol;
    private By resultTextBox = By.name("expr");
    private By clearKey = By.linkText("C");
    private By equalKey = By.linkText("=");

    /**
     * Constructs the page with a web driver as input.
     * @param driver - Web driver to de used.
     */
    public CalculadoraPage(WebDriver driver){
        this.driver = driver;
        operatorSymbol = new OperatorSymbol();
    }

    /**
     * Allows to get the result from result text box.
     * @return - Result of the performed operation.
     */
    public String getResult() {
        return driver.findElement(resultTextBox).getAttribute("value");
    }

    /**
     * Presses the key according to string input.
     * @param key - Key to be pressed.
     */
    public void pressKey(String key) {
        driver.findElement(By.linkText(key)).click();
    }

    /**
     * Presses the operator key according to operation enum input.
     * @param operation - Operation key to be pressed.
     */
    public void pressKey(Operations operation) {
        pressKey(operatorSymbol.getKeySymbol(operation));
    }

    /**
     * Clears the result from result text box by pressing C key.
     */
    public void clearResult() {
        driver.findElement(clearKey).click();
    }

    /**
     * Presses equal key.
     */
    public void pressEqual() {
        driver.findElement(equalKey).click();
    }

    /**
     * Enters the given number.
     * @param number - Number to be entered.
     */
    public void enterNumber(double number) {
        String numberString = Double.toString(number);
        int numberLength = numberString.length();
        for (int index = 0; index < numberLength; index++) {
            char digitIndex = numberString.charAt(index);
            if(digitIndex == '.') {
                pressKey("·");
            } else {
                pressKey(Character.toString(digitIndex));
            }
        }
    }

    /**
     * Perform the given operation using the given numbers.
     * @param number1 - First number to be entered.
     * @param number2 - Second number to be entered.
     * @param operation - Operation to be performed between the given numbers.
     */
    public void operation(double number1, double number2, Operations operation) {
        clearResult();
        enterNumber(number1);
        pressKey(operation);
        enterNumber(number2);
        pressEqual();
    }
}
