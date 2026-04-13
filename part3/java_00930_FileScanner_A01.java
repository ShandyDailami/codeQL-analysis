import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00930_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}