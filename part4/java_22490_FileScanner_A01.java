import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_22490_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("example.txt"); // replace with your file path
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            System.out.println("Number of lines in the file: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}