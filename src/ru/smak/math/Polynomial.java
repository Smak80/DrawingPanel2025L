package ru.smak.math;

public class Polynomial implements Function{

    @Override
    public double invoke(double x) {
        return 2.0 * x * x * x - 3.0 * x * x + 4 * x - 1;
    }
}