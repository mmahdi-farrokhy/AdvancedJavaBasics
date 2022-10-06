public class CarTest {

    class Car{
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

        void move(){
            if (doorClosed && engineOn)
                readyToMove = true;
            else
                readyToMove = false;
        }
    }

}
