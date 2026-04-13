import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35958_FileScanner_A08 {

    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println(file.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}