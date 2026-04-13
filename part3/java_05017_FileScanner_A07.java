import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05017_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.println("Please enter a directory path:");
        String directoryPath = scanner.nextLine();

        // Ensure the user input is valid
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        // Use a FileFilter to only list .txt files
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // Print all the .txt files
        for (File file : txtFiles) {
            System.out.println(file.getName());
        }
    }
}