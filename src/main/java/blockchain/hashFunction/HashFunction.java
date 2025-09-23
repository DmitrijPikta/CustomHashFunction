package blockchain.hashFunction;

import java.util.Arrays;

public class HashFunction {
    public String hash(String input){
        // Convert symbols to int
        int[] inputArray = input.chars().toArray();
        System.out.println(Arrays.toString(inputArray));
        for (int i = 0; i < inputArray.length - 2; i++){
            inputArray[i] = (inputArray[i + 1] + inputArray[i + 2]) % inputArray[i];
        }
        return Arrays.toString(inputArray);
    }
}
