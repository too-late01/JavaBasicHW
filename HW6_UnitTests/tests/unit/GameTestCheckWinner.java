package ru.otus.java.HW6_UnitTests.tests.unit;

import org.junit.Test;
import ru.otus.java.HW6_UnitTests.Assertions.Assertions;
import ru.otus.java.HW6_UnitTests.game.*;
import ru.otus.java.HW6_UnitTests.tests.unit.fakes.DiceImplStub;
import ru.otus.java.HW6_UnitTests.tests.unit.fakes.DiceImplStub02;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static ru.otus.java.HW6_UnitTests.Assertions.Assertions.assertEquals;
import static ru.otus.java.HW6_UnitTests.Assertions.Assertions.assertThrows;

public class GameTestCheckWinner {
  @Test
    public void  testPlayer1Wins() {
        String scenario = "Проверка, что победитель - 1 игрок";
        try {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent)); //все принтлн записываются в outContent

                Dice dice = new DiceImplStub();
                GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
                Game game = new Game(dice, winnerPrinter);

                Player player1 = new Player("John");
                Player player2 = new Player("Jane");

                game.playGame(player1, player2);
                String actualString = outContent.toString();
                String expectedString = "Победитель: John\n";
                Assertions.assertEquals(expectedString, actualString);
                System.setOut(System.out); // гугл говорит, что это должно остановить запись в outContent

                System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());

        }
    }

    @Test
    public void  testWinWin() {
        String scenario = "Проверка, если выпадает ничья";
        try {

            Dice dice = new DiceImplStub02();
            GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
            Game game = new Game(dice, winnerPrinter);

            Player player1 = new Player("John");
            Player player2 = new Player("Jane");

            game.playGame(player1, player2);
            assertThrows(NullPointerException.class, () -> game.playGame(player1, player2));
            //корректно указано какое должно выпасть исключение?

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());

        }
    }
}
