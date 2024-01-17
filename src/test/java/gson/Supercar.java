package gson;

import net.bytebuddy.implementation.bind.annotation.Super;

public class Supercar {

    private String brand;
    private String model;
    private int horsePower;

    private int topSpeed;

    private Boolean isElectic;

    Supercar(){
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public Boolean getElectic() {
        return isElectic;
    }

    public void setElectic(Boolean electic) {
        this.isElectic = electic;
    }
}
