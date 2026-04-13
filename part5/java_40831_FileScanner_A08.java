import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java_40831_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/main/resources/test.txt"));
        Map<String, Integer> wordCounts = new HashMap<>();

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }

            lineScanner.close();
        }

        fileScanner.close();

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }
}