import java.io.File;
import java.util.Scanner;

public class java_16000_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("."); // Get the current directory
        String extension = ".txt"; // We only care about files with this extension

        // Iterate over all files in the directory
        for (File file : directory.listFiles()) {
            // If the file is a file and ends with the specified extension
            if (file.isFile() && file.getName().endsWith(extension)) {
                try (Scanner scanner = new Scanner(file)) {
                    // Print the content of the file
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        }
    }
}