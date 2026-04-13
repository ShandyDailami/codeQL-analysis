import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41607_FileScanner_A03 {
    public static void main(String[] args) {
        String fileName = "example.txt"; // replace with your file name
        String targetString = "A"; // replace with your target string

        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount += countTargetStringInLine(line, targetString);
            }

            System.out.println("Number of lines containing '" + targetString + "' is: " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static int countTargetStringInLine(String line, String targetString) {
        int count = 0;
        String[] words = line.split(" ");
        for (String word : words) {
            if (word.contains(targetString)) {
                count++;
            }
        }
        return count;
    }
}