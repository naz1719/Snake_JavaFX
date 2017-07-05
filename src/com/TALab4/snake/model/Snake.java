package com.TALab4.snake.model;

import com.TALab4.snake.controller.SnakeController;
import com.TALab4.snake.enums.Direction;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.LinkedList;

/**
 * Created by khimin on 03.07.17.
 */
public class Snake extends LinkedList<Point> {
    private GraphicsContext graphicsContext;
    private Direction direction = Direction.UP;

    public Snake(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        reset();
    }

    /**
     * clear frame and set first peace of body, point of start, direction
     */
    public void reset() {
        // The frame action of the snake.
        graphicsContext.clearRect(0, 0,
                SnakeController.gridBounds.getWidth(),
                SnakeController.gridBounds.getHeight());
        clear();
        direction = Direction.UP;
        addFirst(new Point(SnakeController.columns / 2 * SnakeController.cellSize,
                SnakeController.rows / 2 * SnakeController.cellSize));
    }

    public int getScore() {
        return size() - 1;
    }

    public boolean addHead() {
        Point head = new Point(getFirst());
        head.translate(direction.getX(), direction.getY());
        if (!head.checkBounds(SnakeController.gridBounds) || contains(head)) {
            reset();
            return false;
        }
        addFirst(head);

        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillRect(head.getX(), head.getY(),
                SnakeController.cellSize, SnakeController.cellSize);

        return true;
    }

    public boolean eats(Food food) {
        boolean isHungry = false;
        if (getFirst().equals(food)) {
            isHungry = true;
        } else {
            Point tail = removeLast();
            graphicsContext.clearRect(tail.getX() + 1, tail.getY() + 1, SnakeController.cellSize - 1, SnakeController.cellSize - 1);
        }

        return isHungry;
    }

    public void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case D:
            case RIGHT:
                check(Direction.LEFT, Direction.RIGHT);
                break;
            case A:
            case LEFT:
                check(Direction.RIGHT, Direction.LEFT);
                break;
            case W:
            case UP:
                check(Direction.DOWN, Direction.UP);
                break;
            case S:
            case DOWN:
                check(Direction.UP, Direction.DOWN);
                break;
            case ESCAPE:
                System.exit(0);
                break;
            default:
        }
    }

    private void check(Direction check, Direction current) {
        if (direction != check)
            direction = current;
    }
}
