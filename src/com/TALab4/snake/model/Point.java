package com.TALab4.snake.model;

import javafx.geometry.Bounds;

/**
 * Created by khimin on 03.07.17.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.x, point.y);
    }

    public Point() {
        this(0, 0);
    }

    public void translate(int xValue, int yValue) {
        x += xValue;
        y += yValue;
    }

    public boolean checkBounds(Bounds bounds) {
        return x >= bounds.getMinX() && y >= bounds.getMinY()
                && x < bounds.getMaxX() && y < bounds.getMaxY();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Point))
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
