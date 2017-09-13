package com.mycompany.app;

/**
 * Created by helenawenzin on 2017-09-12.
 */
public class GameShowRunner {

    private int wins = 0;
    private int losses = 0;

    public void startGame(int nrOfRuns, boolean contestantShouldSwitchBox) {

        boolean contestantWins;

        for(int i=0; i<nrOfRuns; i++) {
            GameShow gameShow = new GameShow(new Stage(), contestantShouldSwitchBox);
            contestantWins = gameShow.runContest();
            incrementWinsAndLosses(contestantWins);
        }

        printResult();

    }

    private void incrementWinsAndLosses(boolean contestantWins) {
        if(contestantWins) {
            wins++;
        } else {
            losses++;
        }
    }

    public double getWinsInPercentage() {
        return Math.round((double)wins/(wins+losses)*100);
    }

    public double getLossesInPercentage() {
        return Math.round((double)losses/(wins+losses)*100);
    }

    private void printResult() {
        System.out.println("Wins: " + getWinsInPercentage() + "%  Losses: " + getLossesInPercentage() + "%");
    }
}
