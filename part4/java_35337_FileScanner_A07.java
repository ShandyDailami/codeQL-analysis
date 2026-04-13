import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;

public class java_35337_FileScanner_A07 {
    // We use SecureRandom for generating a secure random salt
    private static final SecureRandom secureRandom = new SecureRandom();

    // We use java.nio.file.Files for file operations
    private static final Path path = Paths.get("./data.txt");

    public static void main(String[] args) {
        try {
            // Create a file with a random salt and try to read it
            Files.createFile(path);
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            Files.write(path, salt, StandardOpenOption.APPEND);

            // Try to read the file
            byte[] readBytes = Files.readAllBytes(path);
            System.out.println("Salt read from file: " + new String(readBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}