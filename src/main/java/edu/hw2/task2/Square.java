package edu.hw2.task2;

public class Square extends Rectangle {
    private int side = 0;
    private boolean heightEntered = false;
    private boolean widthEntered = false;

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        widthEntered = true;
        side = width;
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        heightEntered = true;
        side = height;
    }

    @Override
    public double area() {
        if (widthEntered && heightEntered) {
            return super.area();
        }
        return side * side;
    }
}
