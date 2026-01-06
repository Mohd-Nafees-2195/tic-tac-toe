package com.game.model;

import com.game.Enum.CellState;
import com.game.Enum.GameState;
import com.game.exceptions.InvalidMoveException;
import com.game.exceptions.PlayerValidationExceptions;
import com.game.strategies.winningStrategies.WinningStrategies;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private Integer nextPlayerIndex;
    private GameState gameState;
    private List<WinningStrategies> strategies;

    Scanner scanner=new Scanner(System.in);

    private Game(Builder builder) {
        this.players = builder.players;
        this.board=new Board(players.size()+1);
        this.moves=new ArrayList<>();
        this.nextPlayerIndex=0;
        this.gameState=GameState.IN_PROGRESS;
        this.strategies=builder.strategies;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }


    public static Builder getGame(){
        return new Builder();
    }

    public GameState makeMove() throws InvalidMoveException {

        Player currPlayer=players.get(nextPlayerIndex);
        Cell selectedCell=currPlayer.selectCell(board);
        int row=selectedCell.getRow();
        int col=selectedCell.getColumn();
        //Checking for valid move;
        if(!isValidMove(row,col)){
            throw new InvalidMoveException("Move is not valid");
        }
        Cell currCell=board.getCells().get(row).get(col);
        currCell.setCellState(CellState.FILLED);
        currCell.setPlayer(currPlayer);
        Move newMove=new Move(players.get(nextPlayerIndex),currCell);
        moves.add(newMove);
        //Checking for winning
        for(WinningStrategies strategy:strategies){
            if(strategy.checkWinningStrategy(board,newMove)){
                gameState=GameState.WINNER;
                winner=players.get(nextPlayerIndex);
                return gameState;
            }
        }
        //Checking for draw
        if(moves.size() == board.getDimensions() * board.getDimensions()){
            gameState=GameState.DRAW;
            return gameState;
        }
        nextPlayerIndex=(nextPlayerIndex+1)%players.size();
        return gameState;
    }
    public boolean isValidMove(int row,int column){

        if(row>=0&&row<board.getDimensions()&&column>=0&&column<board.getDimensions()){
            return board.getCells().get(row).get(column).getCellState() == CellState.EMPTY;
        }
        return false;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void unDo() {

        if(moves.size()==0){
            System.out.println("Invalid Action");
            return;
        }
        Move move=moves.get(moves.size()-1);
        moves.remove(move);

        //Update the board
        Cell cell=move.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        nextPlayerIndex=(nextPlayerIndex-1+players.size())%players.size();
        //undo winning strategies
        for(WinningStrategies  strategy: strategies){
            strategy.unDo(move,board.getDimensions());
        }

    }

    public Player getCurrentPlayer() {
        return players.get(nextPlayerIndex);
    }

    /**
      Creating Instance using Builder Pattern
     * */
    public static class Builder{
        private List<Player> players;
        List<WinningStrategies> strategies;

        public Builder setPlayers(List<Player> players) throws PlayerValidationExceptions {
            if(players.isEmpty()||players.size()==1){
                throw new PlayerValidationExceptions("There must be at least two player");
            }
            this.players = players;
            return this;
        }

        public Builder setStrategies(List<WinningStrategies> strategies) {
            this.strategies = strategies;
            return this;
        }

        public Game build(){
           return new Game(this);
        }
    }
}
