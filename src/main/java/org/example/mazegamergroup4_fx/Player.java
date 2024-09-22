package org.example.mazegamergroup4_fx;



import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;

public class Player {
    private int playerX = 1, playerY = 1; // Player's starting position in the grid
    private Rectangle playerRect;
    private Maze maze;

    public Player(Maze maze) {
        this.maze = maze;
        playerRect = new Rectangle(Maze.TILE_SIZE - 2, Maze.TILE_SIZE - 2, Color.BLUE);
        playerRect.setTranslateX(playerX * Maze.TILE_SIZE + 1);
        playerRect.setTranslateY(playerY * Maze.TILE_SIZE + 1);
    }

    // Draw the player on the screen
    public void drawPlayer(Pane root) {
        root.getChildren().add(playerRect);
    }

    // Handle arrow key presses to move the player
    public void handleKeyPress(KeyEvent event) {
        int newX = playerX;
        int newY = playerY;

        switch (event.getCode()) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            default:
                break;
        }

        if (maze.canMoveTo(newX, newY)) {
            playerX = newX;
            playerY = newY;
            updatePlayerPosition();
        }
    }

    // Update the player's position on the screen
    private void updatePlayerPosition() {
        playerRect.setTranslateX(playerX * Maze.TILE_SIZE + 1);
        playerRect.setTranslateY(playerY * Maze.TILE_SIZE + 1);
    }

    // Getter methods for player position
    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }
}
