package ru.otus.java.HW6_UnitTests.tests.unit;

import org.junit.Test;
import ru.otus.java.HW6_UnitTests.Assertions.Assertions;
import ru.otus.java.HW6_UnitTests.game.Dice;
import ru.otus.java.HW6_UnitTests.game.DiceImpl;

public class DiceImplTestNegativeNumber {
    private final int ZERO = 0;

    @Test
    public void testRoll() {
        String scenario = "Проверка, что случайное число не отрицательно";
        try {
            Dice dice = new DiceImpl();
            int result = dice.roll();
            boolean checkResult;
            if (result <ZERO) checkResult = false;
            else checkResult = true;
            Assertions.assertEquals(true, checkResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
