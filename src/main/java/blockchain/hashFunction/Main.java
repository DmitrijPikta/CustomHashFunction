package blockchain.hashFunction;


public class Main {
    public static void main(String[] args) {
        HashFunction hasher = new HashFunction();
        String salt = "fdfsfvdsvfdvf";

        /*System.out.println(hasher.hashFile("data/big1.txt", salt));
        System.out.println(hasher.hashFile("data/big2.txt", salt));
        System.out.println(hasher.hashFile("data/big3.txt", salt));
        System.out.println(hasher.hashFile("data/empty.txt", salt));
        System.out.println(hasher.hashFile("data/oneSymbol1.txt", salt));
        System.out.println(hasher.hashFile("data/oneSymbol2.txt", salt));*/

        HashSpeedTest test = new HashSpeedTest();
        System.out.println(test.test("data/konstitucija.txt"));
    }
}
