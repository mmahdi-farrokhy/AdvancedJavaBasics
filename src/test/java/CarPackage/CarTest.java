package CarPackage;

import calculator.CarPackage.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void doorClosed_engineOn() {
        // Given
        Car toyota = new Car("Land Cruise");
        Car kia = new Car("Spoprtage");
        // When
        boolean move = toyota.canMove();
        kia.startEngine();
        kia.openClose();
        boolean kiaCanMove = kia.canMove();

                // Then
        assertFalse(move);
        assertTrue(kiaCanMove);
    }
}
