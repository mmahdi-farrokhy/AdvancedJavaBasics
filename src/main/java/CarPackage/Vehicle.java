package CarPackage;

public abstract class Vehicle {
    public boolean engineOn;
    public String brand;

    public void startEngine(){
        engineOn = true;
    }

    void stopEngine(){
        engineOn = false;
    }

    public abstract boolean canMove();
}
