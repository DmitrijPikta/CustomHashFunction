package blockchain.hashFunction;


public class Main {
    public static void main(String[] args) {
        RandomStringPairsFileGenerator pairsFileGenerator = new RandomStringPairsFileGenerator();
        pairsFileGenerator.generateStringPairsFile("data/pairs10.txt", 100000, 10);
        pairsFileGenerator.generateStringPairsFile("data/pairs100.txt", 100000, 100);
        pairsFileGenerator.generateStringPairsFile("data/pairs500.txt", 100000, 500);
        pairsFileGenerator.generateStringPairsFile("data/pairs1000.txt", 100000, 1000);
    }
}
