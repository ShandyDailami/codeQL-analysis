import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13783_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");

        // Print all files in the directory
        System.out.println("Files in the directory:");
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        // Exclude a specific file
        File specificFile = new File("exclude.txt");
        System.out.println("Contents of excluded file:");
        try (Scanner scanner = new Scanner(specificFile)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + specificFile.getName());
        }
    }
}