package model;

public class NewReleaseMovie implements MovieType{

    @Override
    public double calculateAmount(int days) {
        return days * 3;
    }
}
