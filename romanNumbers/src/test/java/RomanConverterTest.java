import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanConverterTest {
    @Test
    public void romanToDecimal_oneDigitNumberI_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("I");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberV_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("V");
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberX_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("X");
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberL_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("L");
        int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberC_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("C");
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumber_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("D");
        int expected = 500;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberM_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("M");
        int expected = 1000;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberXIII_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("XIII");
        int expected = 13;
        assertEquals(expected, actual);
    }

    @Test
    public void romanToDecimal_oneDigitNumberMMXIX_correctResult() {
        RomanConverter converter = new RomanConverter();
        int actual = converter.romanToDecimal("MMXIX");
        int expected = 2019;
        assertEquals(expected, actual);
    }
}