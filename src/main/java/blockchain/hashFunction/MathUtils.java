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

    public static String toHex(int integer){
        return String.format("%x", integer);
    }

    public static String sumHex(String ...hexIntegers){
        if (hexIntegers.length == 0){
            return null;
        }
        int integersSuma = 0;
        for (String hexInteger : hexIntegers){
            try {
                integersSuma += Integer.parseInt(hexInteger, 16);
            } catch (Exception e){
                throw new IllegalArgumentException(hexInteger + " is not hex number");
            }
        }
        return toHex(integersSuma);
    }

    public static String sumHex(StringBuilder hexNumbers){
        if (hexNumbers.isEmpty()){
            return null;
        }
        int integersSuma = 0;
        for (int i = 0; i < hexNumbers.length(); i++){
            try {
                integersSuma += Integer.parseInt(hexNumbers.substring(i, i + 1), 16);
            } catch (Exception e){
                throw new IllegalArgumentException(hexNumbers.substring(i, i + 1) + " is not hex number");
            }
        }
        return toHex(integersSuma);
    }
}
