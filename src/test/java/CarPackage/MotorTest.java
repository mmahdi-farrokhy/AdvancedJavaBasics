package CarPackage;

import calculator.CarPackage.Motor;
import calculator.CarPackage.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MotorTest {
    @Test
    void shouldBeStarted() {
        // Given
        Vehicle m = new Motor("Suziki");

        // When
        m.startEngine();
        // Then
        Assertions.assertTrue(m.engineOn);
    }
}
