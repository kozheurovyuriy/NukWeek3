package model;

public class RegularMovie implements MovieType{

    @Override
    public double calculateAmount(int days) {
        double result = 2.0;
        result = (days > 2) ? (result + ((days - 2) * 1.5)) : result;
        return result;
    }
}
