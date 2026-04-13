import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17823_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File(".");
        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNext()) {
                File nextFile = scanner.nextFile();
                System.out.println(nextFile.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}