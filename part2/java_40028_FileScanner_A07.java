import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java_40028_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file.txt");

        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        Map<String, Integer> wordCounts = new HashMap<>();

        try (Scanner scanner = new Scanner(Paths.get(file.getPath()))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        wordCounts.forEach((word, count) -> System.out.println("'" + word + "' appears " + count + " times."));
    }
}