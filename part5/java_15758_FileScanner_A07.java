import java.io.File;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class java_15758_FileScanner_A07 {
    private static final SecureRandom rand = new SecureRandom();

    public static void main(String[] args) {
        // Load a list of words to avoid using common words
        List<String> words = Arrays.asList("bad", "dangerous", "unauthorized", "unsecure", "unsafe", "weak", "weakness", "hack", "vulnerability", "security");

        try {
            File file = new File(".");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (String word : words) {
                    if (line.toLowerCase().contains(word)) {
                        System.out.println("Potential security breach detected: " + line);
                        break;
                    }
                }
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}