package ru.otus.java.HW6_UnitTests.tests.unit;


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
    public interface GameWinnerSaver {
        String printWinner(Player winner);
    }

    public class GameWinnerConsolePrinter implements GameWinnerSaver {
        @Override
        public String printWinner(Player winner) {
            String winnerName = winner.getName();
            return winnerName;
        }
    }
    private static class TestGame extends Game {
        private String winnerName;
        private Player winner;
        Dice dice;
        GameWinnerPrinter winnerPrinter;
        public TestGame(Dice dice, GameWinnerPrinter winnerPrinter) {
            super(dice, winnerPrinter);
        this.dice = dice;
        this.winnerPrinter = winnerPrinter;}

        public String playGameTest (Player player1, Player player2) {
            int player1Result = dice.roll();
            int player2Result = dice.roll();

            Player winner = (player1Result > player2Result)? player1: player2;
            String winnerName = winner.getName();
            return winnerName;
        }

    }
    public void  testPlayer1WinsSecond() {
        String scenario = "Проверка, что победитель - 1 игрок (через наследование)";
        try {
            Dice dice = new DiceImplStub();
            GameWinnerPrinter winnerPrinter = new ru.otus.java.HW6_UnitTests.game.GameWinnerConsolePrinter();
            TestGame game = new TestGame(dice, winnerPrinter);
            Player player1 = new Player("John");
            Player player2 = new Player("Jane");
            String expectedString = "John";
            assertEquals(expectedString, game.playGameTest(player1, player2));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());

        }
    }
}

