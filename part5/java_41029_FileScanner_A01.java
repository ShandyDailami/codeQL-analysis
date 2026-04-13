import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41029_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory to scan
        System.out.print("Enter the directory to scan: ");
        String directory = scanner.nextLine();

        // Prompt the user for the file to search
        System.out.print("Enter the file to search: ");
        String fileName = scanner.nextLine();

        // Create a new File object for the directory
        File dir = new File(directory);

        // Create a new File object for the file in the directory
        File file = new File(dir, fileName);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Check if the file is readable
        if (!file.canRead()) {
            System.out.println("Access denied!");
            return;
        }

        // Try to open the file and create a scanner for its contents
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}