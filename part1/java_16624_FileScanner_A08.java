import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class java_16624_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        // Create a hash map to store the expected hashes
        HashMap<String, String> expectedHashes = new HashMap<>();
        expectedHashes.put("file1.txt", "3b2965696e2e48ad69612e4c2e6d452e");
        expectedHashes.put("file2.txt", "a98f211c4c809e7a91e88f2152d89959");

        // Scan for files in the current directory
        FileScanner(new File("."), expectedHashes);
    }

    public static void FileScanner(File start, HashMap<String, String> expectedHashes) throws Exception {
        File[] files = start.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    FileScanner(file, expectedHashes);
                } else {
                    checkFileIntegrity(file, expectedHashes);
                }
            }
        }
    }

    public static void checkFileIntegrity(File file, HashMap<String, String> expectedHashes) throws Exception {
        // Use the first 8 characters of the file's path as a hash key
        String hashKey = file.getPath().substring(0, 8);

        // Check if the expected hash exists in the map
        if (expectedHashes.containsKey(file.getName())) {
            if (!expectedHashes.get(file.getName()).equals(calculateHash(file))) {
                throw new Exception("Integrity check failure for file: " + file.getName());
            }
        } else {
            throw new Exception("Unexpected file: " + file.getName());
        }
    }

    public static String calculateHash(File file) throws Exception {
        // This is a simple hash function that calculates the MD5 of the file's content
        // You may want to use a more secure hash function or use a library like Apache Commons
        return MD5.hash(file).toString();
    }
}