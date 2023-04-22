import static org.junit.jupiter.api.Assertions.*;

class PolyTest {

    @org.junit.jupiter.api.Test
    void testAdd() {
        String expectedValue = "0";
        Poly numberOne = new Poly("0");
        Poly numberTwo = new Poly("0");
        numberOne = numberOne.add(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "1";
        numberOne = new Poly("1");
        numberTwo = new Poly("0");
        numberOne = numberOne.add(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "2";
        numberOne = new Poly("1");
        numberTwo = new Poly("1");
        numberOne = numberOne.add(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "1+2x";
        numberOne = new Poly("1");
        numberTwo = new Poly("2x");
        numberOne = numberOne.add(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "1+2x+3x^2";
        numberOne = new Poly("1");
        numberTwo = new Poly("2x+3x^2");
        numberOne = numberOne.add(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "2+x-x^2";
        numberOne = new Poly("1+x");
        numberTwo = new Poly("1-x^2");
        numberOne = numberOne.add(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

    }

    @org.junit.jupiter.api.Test
    void testSubtract() {
        String expectedValue = "0";
        Poly numberOne = new Poly("0");
        Poly numberTwo = new Poly("0");
        numberOne = numberOne.subtract(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "-1";
        numberOne = new Poly("0");
        numberTwo = new Poly("1");
        numberOne = numberOne.subtract(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "2";
        numberOne = new Poly("1");
        numberTwo = new Poly("-1");
        numberOne = numberOne.subtract(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "1-2x";
        numberOne = new Poly("1");
        numberTwo = new Poly("2x");
        numberOne = numberOne.subtract(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "-1-2x-3x^2";
        numberOne = new Poly("-1");
        numberTwo = new Poly("2x+3x^2");
        numberOne = numberOne.subtract(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "x+x^2";
        numberOne = new Poly("1+x");
        numberTwo = new Poly("1-x^2");
        numberOne = numberOne.subtract(numberTwo);

        assertEquals(expectedValue, numberOne.toString());
    }

    @org.junit.jupiter.api.Test
    void testMultiply() {
        String expectedValue = "0";
        Poly numberOne = new Poly("x");
        Poly numberTwo = new Poly("0");
        numberOne = numberOne.multiply(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "0";
        numberOne = new Poly("1");
        numberTwo = new Poly("0");
        numberOne = numberOne.multiply(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "1";
        numberOne = new Poly("1");
        numberTwo = new Poly("1");
        numberOne = numberOne.multiply(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "2x";
        numberOne = new Poly("1");
        numberTwo = new Poly("2x");
        numberOne = numberOne.multiply(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "2x+3x^2";
        numberOne = new Poly("1");
        numberTwo = new Poly("2x+3x^2");
        numberOne = numberOne.multiply(numberTwo);

        assertEquals(expectedValue, numberOne.toString());

        expectedValue = "1+x-x^2-x^3";
        numberOne = new Poly("1+x");
        numberTwo = new Poly("1-x^2");
        numberOne = numberOne.multiply(numberTwo);

        assertEquals(expectedValue, numberOne.toString());
    }

    @org.junit.jupiter.api.Test
    void testDifferentiate() {
        Poly numberOne = new Poly("0");
        numberOne = numberOne.differentiate();
        String expectedValue = "0";
        assertEquals(expectedValue, numberOne.toString());


        numberOne = new Poly("x^2");
        numberOne = numberOne.differentiate();
        expectedValue = "2x";
        assertEquals(expectedValue, numberOne.toString());

        numberOne = new Poly("4x+9x^2+16x^3+25x^4");
        numberOne = numberOne.differentiate();
        expectedValue = "4+18x+48x^2+100x^3";
        assertEquals(expectedValue, numberOne.toString());

        numberOne = new Poly("4x-9x^2-16x^3+25x^4");
        numberOne = numberOne.differentiate();
        expectedValue = "4-18x-48x^2+100x^3";
        assertEquals(expectedValue, numberOne.toString());

        numberOne = new Poly("1-2x+3x^2-4x^3+5x^4-6x^5");
        numberOne = numberOne.differentiate();
        expectedValue = "-2+6x-12x^2+20x^3-30x^4";
        assertEquals(expectedValue, numberOne.toString());

    }
}