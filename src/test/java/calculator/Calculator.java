package calculator;

import static java.lang.Double.parseDouble;

public class Calculator {
    public String add(String num1, String num2) {
        double result = 0;
        double d1 = parseDouble(num1);
        double d2 = parseDouble(num2);

        result = d1 + d2;

        return String.valueOf(result);
    }
}
