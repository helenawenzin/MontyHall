package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by helenawenzin on 2017-09-12.
 */
public class Stage {

    private Random random = new Random();
    private List<Box> boxList = new ArrayList<Box>();
    private Box firstChosenBoxByContestant;
    private Box boxToSelect;


    public Stage() {
        int randomBoxNumberForWin = random.nextInt(3) + 1;

        Box box1 = new Box(1, 1 == randomBoxNumberForWin);
        Box box2 = new Box(2, 2 == randomBoxNumberForWin);
        Box box3 = new Box(3, 3 == randomBoxNumberForWin);

        boxList.add(box1);
        boxList.add(box2);
        boxList.add(box3);
    }

    public void contestantChoosesBox() {

        int randomBoxNumberChosenByContestant = random.nextInt(3) + 1;
        firstChosenBoxByContestant = getBoxByNumber(randomBoxNumberChosenByContestant);
        firstChosenBoxByContestant.setBoxChosen(true);
    }

    public void hostOpensFirstBox() {

        List<Box> hostBoxChoices = boxList.stream()
                .filter(box -> !box.isBoxChosen())
                .filter(box -> !box.isWin())
                .collect(Collectors.toList());

        if (hostBoxChoices.size() == 1) {
            hostBoxChoices.get(0).setBoxChosen(true);
        } else {
            int randomBoxForHost = random.nextInt(1) +1;
            hostBoxChoices.get(randomBoxForHost).setBoxChosen(true);
        }
    }

    public void contestantSwitchesBox() {

        boxToSelect = getBoxNeverChosen();
        boxToSelect.setBoxChosen(true);

        //switch box
        firstChosenBoxByContestant.setBoxChosen(false);
    }

    public void contestantKeepsBox() {

        boxToSelect = getBoxNeverChosen();
        boxToSelect.setBoxChosen(false);
    }

    public boolean hostOpensFinalBox() {

        if(boxToSelect.isBoxChosen()){
            return boxToSelect.isWin();
        } else {
            return firstChosenBoxByContestant.isWin();
        }
    }

    private Box getBoxNeverChosen() {
        return boxList.stream()
                .filter(box -> !box.isBoxChosen())
                .findFirst()
                .get();
    }

    private Box getBoxByNumber(final int randomBoxNumberChosenByContestant) {

        return boxList.stream()
                .filter(box -> randomBoxNumberChosenByContestant == box.getBoxNumber())
                .findFirst()
                .get();
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public Box getFirstChosenBoxByContestant() {
        return firstChosenBoxByContestant;
    }
}
