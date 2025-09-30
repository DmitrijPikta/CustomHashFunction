package blockchain.hashFunction;


public class Main {
    public static void main(String[] args) {
        HashFunction hasher = new HashFunction();
        String salt = "fdfsfvdsvfdvf";
        //String hashedInput = hasher.hash("Hello world", salt);
        //System.out.println(hashedInput);

        String hashedFile = hasher.hashFile("data/data.txt", salt);
        System.out.println(hashedFile);
        System.out.println(hasher.hashFile("data/data1.txt", salt));
    }
}
