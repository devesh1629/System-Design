package SnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice
{
    public int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }
    int rollDice() {
        int temp = diceCount;
        int diceVal = 0;
        while (temp > 0) {
            diceVal += ThreadLocalRandom.current().nextInt(1, 6);
            temp--;
        }
        return diceVal;
    }
}
