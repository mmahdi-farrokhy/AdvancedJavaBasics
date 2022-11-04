package CarPackage;

import calculator.CarPackage.Car;
import calculator.CarPackage.Motor;
import calculator.CarPackage.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleTest {
    @Test
    void vehicleShouldBeStarted() {
        Vehicle prado = new Car("Prado");
        Vehicle land_cruise = new Car("Land Cruise");
        Vehicle suzuki = new Motor("Suzuki");
        Vehicle[] vehicles = {prado, land_cruise, suzuki};

        Assertions.assertEquals("Prado", vehicles[0].brand);
        Assertions.assertEquals("Land Cruise", vehicles[1].brand);
        Assertions.assertEquals("Suzuki", vehicles[2].brand);
    }
}
