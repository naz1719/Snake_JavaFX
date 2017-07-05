package com.TALab4.snake.abstraction;

import javafx.geometry.Bounds;

/**
 * Created by khimin on 03.07.17.
 */
public interface PointAbstaction {
    boolean checkBounds(Bounds bounds);
    void translate(int xValue, int yValue);
}
