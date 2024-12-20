package com.education.hszg.select;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    // find the smallest and second smallest

    public void playTournament(int[] players){

        List<Game> games = new ArrayList<>();

        // find first round
        for (int i = 0; i < players.length; i = i + 2) {
            games.add(
                new Game(players[i], players[i+2], null, null)
            );
        }
        // play all following rounds, find when to stop
        Game game1 = games.remove(0);
        Game game2 = games.remove(1);
        games.add(
            new Game(game1.getWinner(), game2.getWinner(), game1, game2)
        );
        // display the winner

        // find the second

    }
}
