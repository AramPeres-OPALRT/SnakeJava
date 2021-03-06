package dev.momo.snake;

import dev.momo.snake.SnakeGame;

public class TickThread extends Thread {

    private final SnakeGame game;

    private long lastTick = System.currentTimeMillis();
    private long tickLength = 200;

    public TickThread(SnakeGame game) {
        this.game = game;
    }

    @Override
    public void run() {

        while (true) {
            if (System.currentTimeMillis() - lastTick < tickLength) {
                try {
                    sleep(tickLength - (System.currentTimeMillis() - lastTick));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            tickLength = 200 / (game.getSnakeSize()-9) + 25;

            game.executeTick(1000/(int)tickLength);
            lastTick = System.currentTimeMillis();
        }
    }
}
