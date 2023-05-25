package ru.otus.java.HW6_UnitTests.tests.unit;

import ru.otus.java.HW6_UnitTests.game.*;
import ru.otus.java.HW6_UnitTests.tests.unit.fakes.DiceImplStub;
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
//    public interface GameWinnerSaver {
//        String printWinner(Player winner);
//    }

    public class GameWinnerSaver  implements GameWinnerPrinter {
        private Player winnerName;
        @Override
        public void printWinner(Player winner) {
            winnerName = winner;
        }
        public Player saveWinner() {
            return winnerName;
        }
    }

    public void  testPlayer1WinsSecond() {
        String scenario = "Проверка, что победитель - 1 игрок (через наследование)";
        try {
            Dice dice = new DiceImplStub();
            GameWinnerSaver winnerPrinter = new GameWinnerSaver();
            Game game = new Game(dice, winnerPrinter);
            Player player1 = new Player("John");
            Player player2 = new Player("Jane");
            game.playGame(player1, player2);
            Player winnerPlayer = winnerPrinter.saveWinner();
            Player expectedString = new Player("John");
            assertEquals(expectedString.getName(), winnerPlayer.getName());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());

        }
    }
}

