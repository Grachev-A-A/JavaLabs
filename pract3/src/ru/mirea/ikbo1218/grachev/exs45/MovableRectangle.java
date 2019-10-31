package ru.mirea.ikbo1218.grachev.exs45;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft, bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    public void setSpeed(int xSpeed, int ySpeed){
        //method with mistake for checking work of isEquSpeed
        topLeft.ySpeed = ySpeed;
        topLeft.xSpeed = xSpeed;
    }

    private boolean isEquSpeed(){
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=MovablePoint{x=" + topLeft.x + ", y="+ topLeft.y+
                    "}, bottomRight=MovablePoint{x=" + bottomRight.x + ", y=" + bottomRight.y +
                    "}, xSpeed = " + topLeft.xSpeed +
                ", ySpeed=" + topLeft.ySpeed +
                "}";
    }

    @Override
    public void moveUp() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveUp();
        bottomRight.moveUp();

    }

    @Override
    public void moveDown() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveDown();
        bottomRight.moveDown();

    }

    @Override
    public void moveLeft() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveLeft();
        bottomRight.moveLeft();

    }

    @Override
    public void moveRight() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveRight();
        bottomRight.moveRight();
    }
}
