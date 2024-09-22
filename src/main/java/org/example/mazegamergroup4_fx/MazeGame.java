package org.example.mazegamergroup4_fx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class MazeGame extends Application {
    private Maze maze;
    private Player player;
    private GameLoop gameLoop;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        maze = new Maze();
        player = new Player(maze);

        maze.drawMaze(root);
        player.drawPlayer(root);

        Scene scene = new Scene(root, Maze.WIDTH * Maze.TILE_SIZE, Maze.HEIGHT * Maze.TILE_SIZE);

        // Setup key press handling
        scene.setOnKeyPressed(player::handleKeyPress);

        primaryStage.setTitle("Maze Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the game
        gameLoop = new GameLoop(player, maze);
        gameLoop.start();
    }
}
