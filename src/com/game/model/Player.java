package com.game.model;

import com.game.Enum.CellState;
import com.game.Enum.PlayerType;
import com.game.exceptions.InvalidMoveException;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    Scanner scanner=new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Cell selectCell(Board board) {
        System.out.println("It's "+this.getName()+" turn");
        System.out.println("Enter the cell coordinates : ");
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        return new Cell(row,col, CellState.EMPTY);
    }
}
