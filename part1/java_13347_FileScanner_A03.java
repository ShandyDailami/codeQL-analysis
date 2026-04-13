import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java_13347_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("path_to_your_text_file.txt");
        scanFile(file);
    }

    public static void scanFile(File file) {
        Map<String, Integer> wordCounts = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    Integer count = wordCounts.get(word);
                    if (count == null) {
                        count = 0;
                    }
                    wordCounts.put(word, count + 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getPath());
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println("Word: '" + entry.getKey() + "' Count: " + entry.getValue());
        }
    }
}