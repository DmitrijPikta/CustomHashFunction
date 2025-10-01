package blockchain.hashFunction;


import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        RandomStringPairsFileGenerator fileGenerator = new RandomStringPairsFileGenerator(true);
        fileGenerator.generateStringPairsFile("data/pairsOneSymbolDifference.txt", 100000, 100);
    }
}
