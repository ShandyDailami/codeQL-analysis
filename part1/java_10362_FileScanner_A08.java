import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_10362_FileScanner_A08 {

    public static void main(String[] args) {

        File file = new File("path/to/your/file"); // replace with your file path

        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;

            while (scanner.hasNextLine()) {
                lineCount++;
                scanner.nextLine();
            }

            System.out.println("Number of lines in file: " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}