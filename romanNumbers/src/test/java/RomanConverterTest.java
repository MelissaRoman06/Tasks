import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RomanConverterTest {
    RomanConverter converter;

    @Before
    public void initializeConverter() {
        converter = new RomanConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_blankSpaces_throwsException() {
        int decimalNumber = converter.romanToDecimal("V I");
    }

    @Test
    public void romanToDecimal_caseInsensitive_correctResult() {
        int decimalNumberLowerCase = converter.romanToDecimal("xi");
        int decimalNumberUpperCase = converter.romanToDecimal("VII");
        assertEquals(11, decimalNumberLowerCase);
        assertEquals(7, decimalNumberUpperCase);
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_invalidCharacters_throwsException() {
        int decimalNumber = converter.romanToDecimal("XIU");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_excessiveConsecutiveLettersMMMM_throwsException() {
        int decimalNumber = converter.romanToDecimal("MMMM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_excessiveConsecutiveLettersCCCC_throwsException() {
        int decimalNumber = converter.romanToDecimal("CCCC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_excessiveConsecutiveLettersXXXX_throwsException() {
        int decimalNumber = converter.romanToDecimal("XXXX");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_excessiveConsecutiveLettersIIII_throwsException() {
        int decimalNumber = converter.romanToDecimal("IIII");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_excessiveConsecutiveLettersDD_throwsException() {
        int decimalNumber = converter.romanToDecimal("DD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_excessiveConsecutiveLettersLL_throwsException() {
        int decimalNumber = converter.romanToDecimal("LL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_excessiveConsecutiveLettersVV_throwsException() {
        int decimalNumber = converter.romanToDecimal("VV");
    }

    @Test
    public void romanToDecimal_supportedConsecutiveLetters_correctResult() {
        int decimalNumber3 = converter.romanToDecimal("III");
        int decimalNumber30 = converter.romanToDecimal("XXX");
        int decimalNumber300 = converter.romanToDecimal("CCC");
        int decimalNumber3000 = converter.romanToDecimal("MMM");
        assertEquals(3, decimalNumber3);
        assertEquals(30, decimalNumber30);
        assertEquals(300, decimalNumber300);
        assertEquals(3000, decimalNumber3000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_restrictionSubtractiveNotation_throwsException() {
        int decimalNumber3 = converter.romanToDecimal("IIX");
    }

    @Test
    public void romanToDecimal_subtractiveNotation_correctResult() {
        int decimalNumber = converter.romanToDecimal("XC");
        assertEquals(90, decimalNumber);
    }

    @Test
    public void romanToDecimal_lotsSubtractiveNotation_correctResult() {
        int decimalNumber = converter.romanToDecimal("MCMXLIV");
        assertEquals(1944, decimalNumber);
    }

    @Test
    public void romanToDecimal_oneCharacter_correctResult() {
        int actual1 = converter.romanToDecimal("I");
        assertEquals(1, actual1);
        int actual5 = converter.romanToDecimal("V");
        assertEquals(5, actual5);
        int actual10 = converter.romanToDecimal("X");
        assertEquals(10, actual10);
        int actual50 = converter.romanToDecimal("L");
        assertEquals(50, actual50);
        int actual100 = converter.romanToDecimal("C");
        assertEquals(100, actual100);
        int actual500 = converter.romanToDecimal("D");
        assertEquals(500, actual500);
        int actual1000 = converter.romanToDecimal("M");
        assertEquals(1000, actual1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_incorrectCombination_throwsException() {
        int decimalNumber = converter.romanToDecimal("XVX");
    }

    @Test
    public void romanToDecimal_inconsistentCase_throwsException() {
        try {
            int decimalNumber = converter.romanToDecimal("XxX");
        } catch (Exception exception) {
            assertEquals("Case is not consistent", exception.getMessage());
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_emptyString_throwsException() {
        int decimalNumber = converter.romanToDecimal("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void romanToDecimal_nullString_throwsException() {
        int decimalNumber = converter.romanToDecimal(null);
    }
}