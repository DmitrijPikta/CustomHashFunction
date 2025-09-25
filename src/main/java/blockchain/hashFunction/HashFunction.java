package blockchain.hashFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static blockchain.hashFunction.MathUtils.sumListIntegers;


public class HashFunction {
    public String hash(String input, String salt){
        input += salt;
        // Convert symbols to int
        int[] inputArray = input.chars().toArray();

        List<Integer> inputList = new ArrayList<>(IntStream.of(inputArray).boxed().toList());
        System.out.println(inputList);

        int inputIntegersSum = sumListIntegers(inputList);
        // In case if sum turned over and is negative
        inputIntegersSum = (inputIntegersSum >= 0) ? inputIntegersSum : inputIntegersSum * -1;
        int additionalInteger = inputIntegersSum % 37 + 7;
        for (int i = 0; i < inputList.size(); i++){
            inputList.set(i, (i * 7 + inputList.get(i)) % additionalInteger);
        }

        int counter = 0;
        while (inputList.size() > 64 && counter < inputList.size()){
            inputList.set(counter, (inputList.get(counter) + 7) * (inputList.getLast() + 7));
            inputList.removeLast();
            counter++;
        }

        // Implementation if size < 64
        System.out.println(inputList);
        System.out.println("-----------------");
        inputList = getMixedIntegers(inputList);

        System.out.println(inputList.size());
        return inputList.toString();
    }

    private List<Integer> getMixedIntegers(List<Integer> input){
        int inputSize = input.size();
        int inputIntegersSum = sumListIntegers(input);
        // In case if sum turned over and is negative
        inputIntegersSum = (inputIntegersSum >= 0) ? inputIntegersSum : inputIntegersSum * -1;
        
        int mixPediod = inputIntegersSum % 7 + 2;

        List<Integer> mixedInput = Arrays.asList(new Integer[inputSize]);
        int iterationIntegersNumber = inputSize / mixPediod;

        int counter = 0;
        for (int i = 0; i < mixPediod; i++){
            int insidePediodMix;
            if (i % 2 == 0){
                insidePediodMix = i / 2;
            } else {
                insidePediodMix = mixPediod - i + (i / 2);
            }
            for (int j = 1; j <= iterationIntegersNumber; j++){
                //mixedInput.charAt(inputSize - mixPediod * j + insidePediodMix) = Character.forDigit(input.get(counter), 10);
                int index = inputSize - mixPediod * j + insidePediodMix;
                mixedInput.set(index, input.get(counter));
                counter++;
            }
        }

        // add to mixedInput last elements and encrypt them
        for (int i = 0; i < inputSize % mixPediod; i++){
            mixedInput.set(i, input.get(counter) * mixPediod / (i + 1));
            counter++;
        }
        return mixedInput;
    }
}
