//Class to perform calculations

public class CalculatorModel {

    public double add(double x, double y){
        return x + y;
    }

    public double sub(double x, double y){
        return x - y;
    }

    public double mul(double x, double y){
        return x * y;
    }

    public double div(double x, double y){
        if (y == 0) throw new ArithmeticException("No Division by 0");
        return x / y;
    }

}
