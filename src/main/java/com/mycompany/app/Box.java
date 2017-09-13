package com.mycompany.app;

/**
 * Created by helenawenzin on 2017-09-12.
 */
public class Box {

    private int boxNumber;
    private boolean win;
    private boolean boxChosen;

    public boolean isWin() {
        return win;
    }

    public Box(int boxNumber, boolean win) {
        this.boxNumber = boxNumber;
        this.win = win;
    }

    public boolean isBoxChosen() {
        return boxChosen;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxChosen(boolean boxChosen) {
        this.boxChosen = boxChosen;
    }


}
