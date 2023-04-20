package ru.otus.java.HW6_UnitTests.tests.unit.fakes;

import ru.otus.java.HW6_UnitTests.game.Dice;

public class DiceImplStub02 implements Dice {
    private boolean isFirstRoll = true;

    @Override
    public int roll() {
        if (isFirstRoll) {
            isFirstRoll = false;
            return 3;
        } else {
            return 3;
        }
    }
}
