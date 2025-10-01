package blockchain.hashFunction;

import java.util.Random;

public class RandomStringGenerator {
    private final Random random = new Random();
    private int lowBound = 48;
    private int upBound = 122;

    public RandomStringGenerator(int lowBound, int upBound){
        this.lowBound = lowBound;
        this.upBound = upBound;
    }

    public RandomStringGenerator(){}

    public String generateString(int stringLength){
        StringBuilder buffer = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int randomLimitedInt = lowBound + (int)(random.nextFloat() * (upBound - lowBound + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
