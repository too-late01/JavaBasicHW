package ru.otus.java.HW6_UnitTests.game;

import java.util.Random;

public class DiceImpl implements Dice {

    @Override
    public int roll() {
        // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
      return new Random().nextInt();
      // return new Random().nextInt(6);
        // return new Random().nextInt(6)+1;
    }
//
//    public void Test01CheckGenerationDicelmpl() {
//                Dice dice = new DiceImpl();
//                int diceRollTest = dice.roll();
//                if (!((diceRollTest>0)&&(diceRollTest < 7))) {
//                    System.err.printf("Test01: Дайсы генерируются неверно (меньше нуля или больше 6)");
//                    System.err.printf(String.valueOf(diceRollTest));
//                } else {
//                    if (diceRollTest==0) {
//                        System.err.printf("Test01: Дайсы генерируются неверно (равен 0)");
//                        System.err.printf(String.valueOf(diceRollTest));
//                    } else System.out.println("Test01: Дайсы генерируются корректно");
//                }
//    }

}
