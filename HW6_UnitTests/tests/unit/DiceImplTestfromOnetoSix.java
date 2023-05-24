package ru.otus.java.HW6_UnitTests.tests.unit;


import ru.otus.java.HW6_UnitTests.Assertions.Assertions;
import ru.otus.java.HW6_UnitTests.game.Dice;
import ru.otus.java.HW6_UnitTests.game.DiceImpl;

public class DiceImplTestfromOnetoSix {
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 6;


    public void testRoll() {
        String scenario = "Проверка, что случайное число генерируется в диапазоне от 1 до 6";
        try {
            Dice dice = new DiceImpl();
        int result = dice.roll();
        boolean checkResult;
        if (result >= MIN_VALUE && result <=MAX_VALUE) checkResult = true;
        else checkResult = false;
       Assertions.assertEquals(true, checkResult);
            System.out.printf("\"%s\" passed %n", scenario);
    } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
