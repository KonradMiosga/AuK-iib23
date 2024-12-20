package com.education.hszg.select;

public class Game {
    private int player1;
    private int player2;
    private Game player1previous;
    private Game player2previous;
    public Game(int player1, int player2, Game player1previous, Game player2previous) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1previous = player1previous;
        this.player2previous = player2previous;
    }

    public int getWinner(){
        return Math.min(getPlayer1(), getPlayer2());
    }

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }
    public int getPlayer2() {
        return player2;
    }
    public void setPlayer2(int player2) {
        this.player2 = player2;
    }
    public Game getPlayer1previous() {
        return player1previous;
    }
    public void setPlayer1previous(Game player1previous) {
        this.player1previous = player1previous;
    }
    public Game getPlayer2previous() {
        return player2previous;
    }
    public void setPlayer2previous(Game player2previous) {
        this.player2previous = player2previous;
    }
}
