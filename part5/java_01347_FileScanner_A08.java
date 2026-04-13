import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01347_FileScanner_A08 {

    public static void main(String[] args) {
        // Directory to scan
        File directory = new File(".");

        // Scanning directory
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Integrity failure: " + e.getMessage());
        }
    }
}