package blockchain.hashFunction;

public class Main {
    public static void main(String[] args) {
        HashFunction hasher = new HashFunction();
        String salt = "fdfsfvdsvfdvf";
        String hashedInput = hasher.hash("ff vfvdv  vfdvdbgvgfbgfbg                         CCCCCCCCCCCCCCCCCCCCCCCCCCCCC        rrrrrrrrrrrrrrrrr dddddd ", salt);
        System.out.println(hashedInput);
    }
}
