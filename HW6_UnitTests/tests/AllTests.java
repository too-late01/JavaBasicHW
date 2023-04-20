package ru.otus.java.HW6_UnitTests.tests;

import ru.otus.java.HW6_UnitTests.Assertions.Assertions;
import ru.otus.java.HW6_UnitTests.game.*;
import ru.otus.java.HW6_UnitTests.tests.unit.DiceImplTestNegativeNumber;
import ru.otus.java.HW6_UnitTests.tests.unit.DiceImplTestfromOnetoSix;
import ru.otus.java.HW6_UnitTests.tests.unit.GameTestCheckWinner;
import ru.otus.java.HW6_UnitTests.tests.unit.fakes.DiceImplStub;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AllTests {
    public static void main(String[] args) {
        new DiceImplTestfromOnetoSix().testRoll();
        new DiceImplTestNegativeNumber().testRoll(); //этот тест то проходит, то падает
        new GameTestCheckWinner().testPlayer1Wins(); // тест падает, если изменить ожидаемое,
        // но если он проходит - то почему то не выдает сообщение об этом
        new GameTestCheckWinner().testWinWin();

    }
}
