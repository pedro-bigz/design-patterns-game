package game.Helpers;

import java.util.Random;

public class RandomGenerator {
    public static Float getFloat() {
        return (new Random()).nextFloat();
    }
}