package ru.smak.converting;

public class Converter {
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;

    private int width;
    private int height;

    public Converter(double xMin, double xMax, double yMin, double yMax){
        setxMin(xMin);
        setxMax(xMax);
        setyMin(yMin);
        setyMax(yMax);
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getxDen(){
        return (int)(width / (xMax - xMin));
    }

    public int getyDen(){
        return (int)(height / (yMax - yMin));
    }

    public int xCrt2Scr(double x){
        return (int)(getxDen() * (x - xMin));
    }
}
