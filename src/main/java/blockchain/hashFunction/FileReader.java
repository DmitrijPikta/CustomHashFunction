package blockchain.hashFunction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class FileReader {
    public String readFile(String filename){
        StringJoiner data = new StringJoiner(System.lineSeparator());
        File file = new File(filename);
        try (Scanner reader = new Scanner(file)){
            while (reader.hasNextLine()){
                data.add(reader.nextLine());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
        return data.toString();
    }
}
