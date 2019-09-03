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

    public boolean isValidRomanNumber(String romanNum) {
        if(romanNum == null) {
            return false;
        } else {
            if (romanNum.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")
                    && !hasBlankSpacesOrNothing(romanNum)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasBlankSpacesOrNothing(String romanNum) {
        if(romanNum.contains(" ") || romanNum.equals("") ) {
            return true;
        }
        return false;
    }

    public boolean isCaseConsistent(String romanNum) {
        if(romanNum == null) {
            return false;
        } else {
            int length = romanNum.length();
            boolean lowerCase = false;
            boolean upperCase = false;
            int countLower = 0;
            int countUpper = 0;
            for (int index = 0; index < length; index++) {
                char indexCharacter = romanNum.charAt(index);
                if (Character.isLowerCase(indexCharacter) ) {
                    countLower++;
                    if(countLower == 1) {
                        lowerCase = true;
                    }
                } else {
                    countUpper++;
                    if(countUpper == 1) {
                        upperCase = true;
                    }
                }
            }
            return !(lowerCase && upperCase);
        }
    }

    public int romanToDecimal(String romanNum) {
        if (isCaseConsistent(romanNum)) {
            String romanNumber = romanNum.toUpperCase();
            if (isValidRomanNumber(romanNumber)) {
                int decimalNumber = 0;
                int decimalNumberAux = 0;
                int previousNumber;
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
            } else {
                throw new IllegalArgumentException("Invalid string input");
            }
        } else {
            throw new IllegalArgumentException("Case is not consistent");
        }
    }
}
