import java.io.File;
import java.util.Scanner;

public class java_29228_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory
        System.out.println("Enter a directory:");
        String dir = scanner.nextLine();

        // Get all files in directory
        File[] files = new File(dir).listFiles();

        // Print file names
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    System.out.println(file.getName());
                }
            }
        }

        // Close scanner
        scanner.close();
    }
}