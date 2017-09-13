package com.mycompany.app;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by helenawenzin on 2017-09-13.
 */
public class GameShowAppTest {

    int nrOfRuns = 10000;

    @Test
    public void switchingBoxInGameShowShouldHaveHigherWins() {

        GameShowRunner gameShowRunner = new GameShowRunner();
        gameShowRunner.startGame(nrOfRuns, true);

        assertThat(gameShowRunner.getWinsInPercentage(), greaterThan((double)60));
    }

    @Test
    public void keepingBoxInGameShowShouldHaveLowerWins() {

        GameShowRunner gameShowRunner = new GameShowRunner();
        gameShowRunner.startGame(nrOfRuns, false);

        assertThat(gameShowRunner.getWinsInPercentage(), lessThan((double)40));
    }
}
