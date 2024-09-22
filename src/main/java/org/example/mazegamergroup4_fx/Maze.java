
package org.example.mazegamergroup4_fx;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Maze {
    public static final int TILE_SIZE = 40;
    public static final int WIDTH = 10;  // Number of columns
    public static final int HEIGHT = 10; // Number of rows

    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
            {1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    // Draw the maze using rectangles
    public void drawMaze(Pane root) {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setTranslateX(col * TILE_SIZE);
                tile.setTranslateY(row * TILE_SIZE);
                if (maze[row][col] == 1) {
                    tile.setFill(Color.BLACK); // Wall
                } else {
                    tile.setFill(Color.WHITE); // Path
                }
                root.getChildren().add(tile);
            }
        }
    }

    // Check if a player can move to a given position
    public boolean canMoveTo(int x, int y) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            return maze[y][x] == 0;
        }
        return false;
    }

    // Check if the player reached the goal
    public boolean isGoalReached(int playerX, int playerY) {
        return playerX == 8 && playerY == 8;
    }
}
