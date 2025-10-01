package blockchain.hashFunction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
class HashFunctionTest {
    HashFunction hasher = new HashFunction();
    String salt = "fdvgfdjuervcdv";

    @ParameterizedTest
    @CsvFileSource(resources = "/filePaths.csv")
    void hashFile_shouldReturnSameSizeString_WhenInputIsDifferentFiles(String filePath){
        String hash = hasher.hashFile(filePath, salt);
        int hashSize = 64;
        assertEquals(hashSize, hash.length());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/filePaths.csv")
    void hashFile_shouldReturnSameHash_WhenInputIsSame(String filepath){
        String firstHash = hasher.hashFile(filepath, salt);
        String secondHash = hasher.hashFile(filepath, salt);
        assertEquals(firstHash, secondHash);
    }
}