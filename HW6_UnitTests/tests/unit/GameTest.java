package ru.otus.java.HW6_UnitTests.tests.unit;

import org.junit.jupiter.api.Test;
import ru.otus.java.HW6_UnitTests.Assertions.Assertions;
import ru.otus.java.HW6_UnitTests.game.*;
import ru.otus.java.HW6_UnitTests.tests.unit.fakes.DiceImplStub;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static ru.otus.java.HW6_UnitTests.Assertions.Assertions.assertEquals;

public class GameTest {

    private static class TestDice implements Dice {
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

    private static class TestGame extends Game {
        private String winner;


        public TestGame(Dice dice, GameWinnerPrinter winnerPrinter) {
            super(dice, winnerPrinter);}

        @Override
        public void playGame(Player player1, Player player2) {
            Dice dice = new TestDice();
            int player1Result = dice.roll();
            int player2Result = dice.roll();

            if (player1Result > player2Result) {
                winner = player1.getName();
            } else {
                winner = player2.getName();
            }
        }

        public String getWinner() {
            return winner;
        }
    }

    public void  testPlayer1WinsSecond() {
        String scenario = "Проверка, что победитель - 1 игрок (через наследование)";
        try {
            Dice dice = new DiceImplStub();
            GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
            TestGame game = new TestGame(dice, winnerPrinter);
            //String winner = null;

            Player player1 = new Player("John");
            Player player2 = new Player("Jane");

            game.playGame(player1, player2);


            String actualString = game.getWinner();
            String expectedString = "John";
            assertEquals(expectedString, actualString);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());

        }
    }
}

