package blockchain.hashFunction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RandomStringPairsFileGenerator {
    private final RandomStringPairsGenerator pairsGenerator;

    public RandomStringPairsFileGenerator(int stringLowBound, int stringUpBound){
        pairsGenerator = new RandomStringPairsGenerator(stringLowBound, stringUpBound);
    }

    public RandomStringPairsFileGenerator(){
        pairsGenerator = new RandomStringPairsGenerator();
    }

    public void generateStringPairsFile(String filename, int pairsNumber, int stringLength){
        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e){
            System.out.println("An error occurred trying create file");
            e.printStackTrace();
            return;
        }

        String generatedPairs = pairsGenerator.generateStringPairs(pairsNumber, stringLength);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(generatedPairs);
            writer.close();
        } catch (IOException e){
            System.out.println("An error occurred trying write to file");
            e.printStackTrace();
        }
    }
}
