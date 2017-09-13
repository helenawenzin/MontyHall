package com.mycompany.app;

/**
 * Created by helenawenzin on 2017-09-12.
 */
public class GameShow {

    private Stage stage;
    private boolean contestantShouldSwitchBox = true;

    public GameShow(Stage stage, boolean contestantShouldSwitchBox) {
        this.stage = stage;
        this.contestantShouldSwitchBox = contestantShouldSwitchBox;
    }

    public boolean runContest() {

        stage.contestantChoosesBox();
        stage.hostOpensFirstBox();

        if(contestantShouldSwitchBox){
            stage.contestantSwitchesBox();
        } else {
            stage.contestantKeepsBox();
        }

        boolean contestantWins = stage.hostOpensFinalBox();

        return contestantWins;
    }

}
