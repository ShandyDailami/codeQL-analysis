import java.io.File;
import java.util.Scanner;

public class java_29810_FileScanner_A08 {

    public static void main(String[] args) {

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory name
        System.out.println("Please enter the directory name:");
        String dirName = scanner.next();

        // Prompt user for file name
        System.out.println("Please enter the file name to filter:");
        String fileName = scanner.next();

        // Close scanner
        scanner.close();

        // Get directory object
        File dir = new File(dirName);

        // Get all files in directory
        File[] files = dir.listFiles();

        // Print out files that match the name
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                System.out.println("File name: " + file.getName());
            }
        }
    }
}