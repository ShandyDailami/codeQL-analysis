import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10847_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = args[0];
        String wordToSearch = args[1];

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        int count = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                count += countOccurrences(line, wordToSearch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

        System.out.println("Count: " + count);
    }

    private static int countOccurrences(String line, String wordToSearch) {
        String[] words = line.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase(wordToSearch)) {
                count++;
            }
        }

        return count;
    }
}