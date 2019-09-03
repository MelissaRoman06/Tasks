import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RomanConverterTest {
    RomanConverter converter;
    @BeforeClass
    public void initializeRomanConverter() {
        converter = new RomanConverter();
    }

    @Test
    public void romanToDecimal_oneDigitNumberI_correctResult() {
        int actual = converter.romanToDecimal("I");
        assertEquals(1, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberV_correctResult() {
        int actual = converter.romanToDecimal("V");
        assertEquals(5, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberX_correctResult() {
        int actual = converter.romanToDecimal("X");
        assertEquals(10, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberL_correctResult() {
        int actual = converter.romanToDecimal("L");
        assertEquals(50, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberC_correctResult() {
        int actual = converter.romanToDecimal("C");
        assertEquals(100, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumber_correctResult() {
        int actual = converter.romanToDecimal("D");
        assertEquals(500, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberM_correctResult() {
        int actual = converter.romanToDecimal("M");
        assertEquals(1000, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberXIII_correctResult() {
        int actual = converter.romanToDecimal("XIII");
        assertEquals(13, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberMMXIX_correctResult() {
        int actual = converter.romanToDecimal("MMXIX");
        assertEquals(2019, actual);
    }

    @Test
    public void isValidRomanNumber_blankSpaces_correctResult() {
        boolean actual = converter.isValidRomanNumber("X V");
        assertEquals(false, actual);
    }

    @Test
    public void isValidRomanNumber_emptyString_correctResult() {
        boolean actual = converter.isValidRomanNumber("");
        assertEquals(false, actual);
    }

    @Test
    public void isValidRomanNumber_null_correctResult() {
        boolean actual = converter.isValidRomanNumber(null);
        assertEquals(false, actual);
    }

    @Test
    public void romanToDecimal_blackSpaces_exception() {

    }
}