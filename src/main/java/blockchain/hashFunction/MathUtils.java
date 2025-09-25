package blockchain.hashFunction;

import java.util.List;

public final class MathUtils {
    private MathUtils(){}

    public static int sumListIntegers(List<Integer> list){
        int sum = 0;
        for (int number : list){
            sum += number;
        }
        return sum;
    }
}
