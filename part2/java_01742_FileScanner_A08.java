import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01742_FileScanner_A08 {
    public static void main(String[] args) {
        String filename = "src/test.txt";
        File file = new File(filename);

        // Check if file exists
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // Check if file is readable
        if (!file.canRead()) {
            System.out.println("File is not readable");
            return;
        }

        System.out.println("File exists and is readable");

        // Use FileScanner to read the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}