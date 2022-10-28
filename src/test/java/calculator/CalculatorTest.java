package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void should_add_two_numbers() {
        Calculator calc = new Calculator();

        String num1 = "13.69";
        String num2 = "69.80";

        String result = calc.add(num1, num2);

        Assertions.assertThat(result).isEqualTo("83.49");

    }
}
