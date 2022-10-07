package CarPackage;

public class Car extends Vehicle implements GearBox, Trunk{
    //Constructor
    public Car(){
        System.out.println("A CarPackage.Car With No Data Is Created");
    }

    public String GearType(String Gear){
        return Gear;
    }

    public int TrunkCapacity(int Capacity){
        return Capacity;
    }

    public Car(String brand){
        this.brand = brand;
    }

    boolean doorClosed;

    void openDoor(){
        doorClosed = false;
    }

    public void openClose(){
        doorClosed = true;
    }

    public boolean canMove(){
        if (doorClosed && engineOn)
            return  true;
        else
            return  false;

    }
}