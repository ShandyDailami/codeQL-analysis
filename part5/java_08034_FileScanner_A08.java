import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08034_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String word = "IntegrityFailure";

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        int count = 0;
        for (File file : listOfFiles) {
            if (file.isFile() && file.canRead()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        count += countOccurrences(line, word);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        }

        System.out.println("The word '" + word + "' occurred " + count + " times.");
    }

    private static int countOccurrences(String text, String word) {
        String[] words = text.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }
}