package com.TALab4.snake.enums;

import com.TALab4.snake.controller.SnakeController;

/**
 * Created by khimin on 03.07.17.
 */
public enum Direction {
    UP(0,-SnakeController.cellSize),
    DOWN(0,SnakeController.cellSize),
    LEFT(-SnakeController.cellSize,0),
    RIGHT( SnakeController.cellSize,0);
    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
