package com.TALab4.snake.model;

import com.TALab4.snake.controller.SnakeController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Created by khimin on 03.07.17.
 */
public class Food extends Point {

    private Random random = new Random();
    private GraphicsContext graphicsContext;

    public Food(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    private int randomizeX() {
        return random.nextInt(SnakeController.columns) * SnakeController.cellSize;
    }

    private int randomizeY() {
        return random.nextInt(SnakeController.rows) * SnakeController.cellSize;
    }

    public void move(Snake snake) {
        do {
            setX(randomizeX());
            setY(randomizeY());
        } while (snake.contains(this));
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillOval(getX(), getY(), SnakeController.cellSize, SnakeController.cellSize);
    }
}
