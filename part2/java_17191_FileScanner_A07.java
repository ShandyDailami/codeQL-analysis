import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;

public class java_17191_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a secure random number generator
        SecureRandom sr = new SecureRandom();
        String fileName = "auth_failure_" + sr.nextInt();

        try {
            // Create a new file
            Path path = Paths.get(fileName);
            Files.createFile(path);

            // Write a message to the file
            Files.write(path, ("AuthFailure detected!").getBytes(), StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}