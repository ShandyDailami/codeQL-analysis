import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java_07498_FileScanner_A07 {
    private static final String FILE_PATH = "src/main/resources/A07_AuthFailure.txt";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        Map<String, Integer> wordCounts = new HashMap<>();

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        wordCounts.put(word.toLowerCase(), wordCounts.getOrDefault(word.toLowerCase(), 0) + 1);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error occurred while reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found at: " + FILE_PATH);
        }

        wordCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}