package Atlassian;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Game implements SnakeGame{

    Queue<Node> body;
    int MAX_MOVE;
    int currMoveCount=0;
    Set<Node> bodyElements;
    final int ROWS; // 0---rows-1
    final int COLS; // 0 --> cols-1

    Game(int MAX_MOVE, int totalRows,int totalCols){
        this.body  = new LinkedList<>();
        this.MAX_MOVE = MAX_MOVE;
        this.bodyElements= new HashSet<>();
        this.ROWS= totalRows;
        this.COLS= totalCols;
        init(body,bodyElements);
    }

    private void init(Queue<Node> body, Set<Node> bodyElements ){
        for(int i=0;i<3;i++){
            Node node = new Node(0,i);
            body.add(node);
            bodyElements.add(node);
        }
    }


    @Override
    public void moveSnake(Direction snakeDirection) {
        Node node = body.peek();
        switch (snakeDirection){
            case UP:
                Node temp = new Node(node.row-1, node.col);
                if(updateSnakeBody(temp)){
                    return;
                }
                break;
            case DOWN:
                temp = new Node(node.row+1, node.col);
                if(updateSnakeBody(temp)){
                    return;
                }
                break;
            case LEFT:
                temp = new Node(node.row, node.col-1);
                if(updateSnakeBody(temp)){
                    return;
                }
                break;
            case RIGHT:
                temp = new Node(node.row, node.col+1);
                if(updateSnakeBody(temp)){
                    return;
                }
                break;
        }
    }

    private boolean updateSnakeBody(Node temp){
        body.add(temp);
        boolean result = isGameOver();
        if (result){
            return false;
        }else{
            currMoveCount++;
            bodyElements.add(temp);
            if(currMoveCount== MAX_MOVE){
               currMoveCount=0;
            }else {
                body.remove();
            }

        }
        return true;
    }

    @Override
    public boolean isGameOver() {

        Node node = body.peek();
        if(bodyElements.contains(node)){
            return true;
        }
        return false;
    }
}
class Node{
    int row;
    int col;
    Node(int row,int col){
        this.row=row;
        this.col=col;
    }
}
