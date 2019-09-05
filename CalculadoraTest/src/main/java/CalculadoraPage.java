import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculadoraPage {
    private WebDriver driver;
    private OperatorSymbol operatorSymbol;
    private By resultTextBox = By.name("expr");
    private By clearKey = By.linkText("C");
    private By equalKey = By.linkText("=");

    public CalculadoraPage(WebDriver driver){
        this.driver = driver;
        operatorSymbol = new OperatorSymbol();
    }

    public String getResult() {
        return driver.findElement(resultTextBox).getAttribute("value");
    }

    public void pressKey(String key) {
        driver.findElement(By.linkText(key)).click();
    }

    public void pressKey(Operations operation) {
        pressKey(operatorSymbol.getKeySymbol(operation));
    }

    public void clearResult() {
        driver.findElement(clearKey).click();
    }

    public void pressEqual() {
        driver.findElement(equalKey).click();
    }

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

    public void operation(double number1, double number2, Operations operation) {
        clearResult();
        enterNumber(number1);
        pressKey(operation);
        enterNumber(number2);
        pressEqual();
    }
}
