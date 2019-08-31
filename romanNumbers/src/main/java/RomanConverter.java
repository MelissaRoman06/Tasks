import java.util.HashMap;
import java.util.Map;

public class RomanConverter {
    private Map<Character, Integer> basicNumbers;

    public RomanConverter() {
        basicNumbers = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
    }
    public int romanToDecimal(String romanNum) {
        String romanNumber = romanNum.toUpperCase();
        int decimalNumber = 0;
        int decimalNumberAux = 0;
        int previousNumber = 0;
        int length = romanNumber.length();
        for (int index = length - 1; index >= 0; index--) {
            char character = romanNumber.charAt(index);
            previousNumber = decimalNumberAux;
            decimalNumberAux = basicNumbers.get(character);
            if (decimalNumberAux < previousNumber) {
                decimalNumber = decimalNumber - decimalNumberAux;
            } else {
                decimalNumber = decimalNumber + decimalNumberAux;
            }
        }
        return decimalNumber;        
    }
}
