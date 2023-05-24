package ru.otus.java.HW6_UnitTests.tests.unit;


import ru.otus.java.HW6_UnitTests.Assertions.Assertions;
import ru.otus.java.HW6_UnitTests.game.Dice;
import ru.otus.java.HW6_UnitTests.game.DiceImpl;

public class DiceImplTestNegativeNumber {
    private final int ZERO = 0;

    public void testRoll() {
        String scenario = "Проверка, что случайное число не отрицательно";
        int counter = 100;
        boolean isTestPassed = true;
        for (int i = 1; i < counter; i++) {
            try {
                Dice dice = new DiceImpl();
                int result = dice.roll();
                boolean checkResult = result >= 0;
                if (!checkResult) {
                    isTestPassed = false;
                    break;
                }
            } catch (Throwable e) {
                isTestPassed = false;
                break;
            }
        }

        if (isTestPassed) {
            System.out.printf("\"%s\" passed%n", scenario);
        } else {
            System.err.printf("\"%s\" failed%n", scenario);
        }
    }
}
