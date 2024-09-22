package org.example.mazegamergroup4_fx;



import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    private Player player;
    private Maze maze;

    public GameLoop(Player player, Maze maze) {
        this.player = player;
        this.maze = maze;
    }

    @Override
    public void handle(long now) {
        checkWinCondition();
    }

    // Check if the player has won
    private void checkWinCondition() {
        if (maze.isGoalReached(player.getPlayerX(), player.getPlayerY())) {
            System.out.println("You Win!");
            stop();
            System.exit(0);  // Terminate the game
        }
    }
}
