package com.mycompany.app;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by helenawenzin on 2017-09-12.
 */
public class StageTest {

    @Test
    public void stageIsCreatedCorrectly() {
        Stage stage = new Stage();

        assertThat(stage.getBoxList().size(), is(3));
        assertThat(stage.getBoxList().stream().filter(box -> box.isWin()).count(), is(1L));
        assertThat(stage.getBoxList().stream().filter(box -> box.isBoxChosen()).count(), is(0L));
    }

    @Test
    public void contestantChoosesBox() {
        Stage stage = new Stage();
        stage.contestantChoosesBox();

        assertThat(stage.getFirstChosenBoxByContestant().isBoxChosen(), is(true));
        assertThat(stage.getBoxList().stream().filter(box -> box.isBoxChosen()).count(), is(1L));
    }

    @Test
    public void hostOpensBox(){
        Stage stage = new Stage();
        stage.contestantChoosesBox();
        stage.hostOpensFirstBox();

        assertThat(stage.getBoxList().stream().filter(box -> box.isBoxChosen()).count(), is(2L));
    }

    @Test
    public  void contestantSwitchesBox() {
        Stage stage = new Stage();
        stage.contestantChoosesBox();
        stage.hostOpensFirstBox();
        stage.contestantSwitchesBox();

        assertThat(stage.getFirstChosenBoxByContestant().isBoxChosen(), is(false));
    }

    @Test
    public void contestantKeepsBox() {
        Stage stage = new Stage();
        stage.contestantChoosesBox();
        stage.hostOpensFirstBox();
        stage.contestantKeepsBox();

        assertThat(stage.getFirstChosenBoxByContestant().isBoxChosen(), is(true));
    }
}
