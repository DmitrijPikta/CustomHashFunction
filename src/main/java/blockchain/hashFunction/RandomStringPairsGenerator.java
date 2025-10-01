package blockchain.hashFunction;

import java.util.StringJoiner;

public class RandomStringPairsGenerator {
    private final RandomStringGenerator randomGenerator;

    public RandomStringPairsGenerator(int stringLowBound, int stringUpBound){
        randomGenerator = new RandomStringGenerator(stringLowBound, stringUpBound);
    }

    public RandomStringPairsGenerator(){
        randomGenerator = new RandomStringGenerator();
    }

    public String generateStringPairs(int pairsNumber, int stringLength){
        StringJoiner generatedPairs = new StringJoiner(System.lineSeparator());
        for (int i = 0; i < pairsNumber; i++){
            StringBuilder generatedPair = new StringBuilder();
            generatedPair.append(randomGenerator.generateString(stringLength));
            generatedPair.append(" ");
            generatedPair.append(randomGenerator.generateString(stringLength));
            generatedPairs.add(generatedPair);
        }
        return generatedPairs.toString();
    }
}
