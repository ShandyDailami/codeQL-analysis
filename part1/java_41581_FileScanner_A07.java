import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_41581_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        try (Scanner scanner = new Scanner(file)) {
            String targetWord = "target_word";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(targetWord)) {
                    System.out.println("Line contains target word: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}