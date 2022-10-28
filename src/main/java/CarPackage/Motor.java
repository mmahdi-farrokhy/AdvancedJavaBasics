package CarPackage;

public class Motor extends Vehicle{


    public Motor(String brand){
        this.brand = brand;
    }

    public boolean canMove(){
        if (engineOn)
            return true;
        else
            return false;
    }
}
