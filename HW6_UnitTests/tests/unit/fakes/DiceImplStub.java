package ru.otus.java.HW6_UnitTests.tests.unit.fakes;

import ru.otus.java.HW6_UnitTests.game.Dice;

public class DiceImplStub implements Dice {
    private boolean isFirstRoll = true;

    @Override
    public int roll() {
        if (isFirstRoll) {
            isFirstRoll = false;
            return 6;
        } else {
            return 2;
        }
    }
}
