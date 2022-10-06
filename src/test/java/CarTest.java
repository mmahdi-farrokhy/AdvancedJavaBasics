import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    class Car{
        //Constructor
        Car(){
            System.out.println("A Car With No Data Is Created");
        }

        Car(String brand){
            this.brand = brand;
        }

        boolean engineOn;
        boolean doorClosed;
        boolean readyToMove;
        String brand;

        void startEngine(){
            engineOn = true;
        }

        void stopEngine(){
            engineOn = false;
        }

        void openDoor(){
            doorClosed = false;
        }

        void openClose(){
            doorClosed = true;
        }

        boolean canMove(){
            if (doorClosed && engineOn)
                return  true;
            else
                return  false;

        }
    }

    @Test
    void doorClosed_engineOn() {
//        Car c2 = new Car("Prado");
//        c2.openDoor();
//        System.out.println("I have a nice " + c2.brand);
//        System.out.println("Is its door closed? " + c2.doorClosed);

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
