package com.mycompany.app;

public class GameShowApp {

    public static void main( String[] args ) {

        int nrOfRuns = 10000;

        GameShowRunner gameShowRunner = new GameShowRunner();
        gameShowRunner.startGame(nrOfRuns, true);

        GameShowRunner gameShowRunner2 = new GameShowRunner();
        gameShowRunner2.startGame(nrOfRuns, false);

    }
}
