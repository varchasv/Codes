package Atlassian;

 /*

move l,r,u,d
every five step one length grows
end - hits own body

  */
public interface SnakeGame {
    void moveSnake(Direction snakeDirection);
    boolean isGameOver();
}
