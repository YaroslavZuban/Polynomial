public class Main {
    public static void main(String[] args) {
        String line1 = "1+2x+3x^2";
        String line2 = "2x+3x^2";
        String line3 = "-1-2x-3x^2";
        String line4 = "1-x^2";
        String line5 = "0";
        String line6 = "-1";
        String line7 = "1";
        String line8 = "2x";
        String line9 = "1+x";
        String line10="x";

        Poly numberOne = new Poly("0");
        numberOne=numberOne.differentiate();
        System.out.println(numberOne);

        numberOne = new Poly("x^2");
        numberOne=numberOne.differentiate();
        System.out.println(numberOne);

        numberOne = new Poly("4x+9x^2+16x^3+25x^4");
        numberOne=numberOne.differentiate();
        System.out.println(numberOne);

        numberOne = new Poly("4x-9x^2-16x^3+25x^4");
        numberOne=numberOne.differentiate();
        System.out.println(numberOne);

        numberOne = new Poly("1-2x+3x^2-4x^3+5x^4-6x^5");
        numberOne=numberOne.differentiate();
        System.out.println(numberOne);

       /* Poly numberOne = new Poly(line10);
        Poly numberTwo = new Poly(line5);
        Poly result = numberOne.multiply(numberTwo);

        System.out.println(result);

        numberOne = new Poly(line7);
        numberTwo = new Poly(line5);
        result = numberOne.multiply(numberTwo);

        System.out.println(result);

        numberOne = new Poly(line7);
        numberTwo = new Poly(line7);
        result = numberOne.multiply(numberTwo);

        System.out.println(result);

        numberOne = new Poly(line7);
        numberTwo = new Poly(line8);
        result = numberOne.multiply(numberTwo);

        System.out.println(result);

        numberOne = new Poly(line7);
        numberTwo = new Poly(line2);
        result = numberOne.multiply(numberTwo);

        System.out.println(result);

        numberOne = new Poly(line9);
        numberTwo = new Poly(line4);
        result = numberOne.multiply(numberTwo);

        System.out.println(result);*/

       /* Poly poly = new Poly(line1);
        System.out.println("line1: " + poly);

        poly = new Poly(line2);
        System.out.println("line2: " + poly);

        poly = new Poly(line3);
        System.out.println("line3: " + poly);

        poly = new Poly(line4);
        System.out.println("line4: " + poly);

        poly = new Poly(line5);
        System.out.println("line5: " + poly);

        poly = new Poly(line6);
        System.out.println("line6: " + poly);*/
    }
}