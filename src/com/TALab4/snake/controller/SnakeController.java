package com.TALab4.snake.controller;

import com.TALab4.snake.model.Food;
import com.TALab4.snake.model.Snake;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;

public class SnakeController {
    final static int SNAKE_SPEED = 100;
    public static int cellSize;
    public static int rows;
    public static int columns;
    public static Bounds gridBounds;

    @FXML
    BorderPane rootPane;
    @FXML
    Canvas canvas;
    @FXML
    Text score;
    private Snake snake;
    private Food food;
    @FXML
    private URL location;

    @FXML
    void initialize() {
        cellSize = (int) Math.round(rootPane.getTop().getBoundsInParent().getHeight());
        gridBounds = rootPane.getCenter().getBoundsInParent();
        rows = (int) Math.floor(gridBounds.getHeight() / cellSize);
        columns = (int) Math.floor(gridBounds.getWidth() / cellSize);


        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        snake = new Snake(graphicsContext2D);
        food = new Food(graphicsContext2D);
        food.move(snake);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(SNAKE_SPEED),
                        new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent event) {
                                if (!snake.addHead() || snake.eats(food)) {
                                    score.setText("Score: " + snake.getScore());
                                    food.move(snake);
                                }
                            }
                        }));
        timeline.playFromStart();
    }

    @FXML
    void handleKeyPressed(KeyEvent event) {
        snake.keyPressed(event);
    }

    @FXML
    public void handleMouseEntered(MouseEvent event) {
        rootPane.requestFocus();
    }
}
