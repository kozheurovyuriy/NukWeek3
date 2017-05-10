package model;

public class ChildrensMovie implements MovieType{

    @Override
    public double calculateAmount(int days) {
        double result = 1.5;
        result = (days > 3) ? (result + ((days - 3) * 1.5)) : result;
        return result;
    }

}
