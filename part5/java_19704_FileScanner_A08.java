import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19704_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object representing the directory we want to scan
        File directory = new File(".");

        // Use a Scanner to list all files in the directory
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println(file.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found");
        }
    }
}