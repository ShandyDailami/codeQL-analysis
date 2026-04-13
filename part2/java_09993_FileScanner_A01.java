import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09993_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file: ");
        String path = scanner.nextLine();

        // Check if the path is valid
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Invalid path");
            return;
        }

        // Check if the file is accessible
        if (!file.canRead()) {
            System.out.println("Access denied for reading the file");
            return;
        }

        try {
            // Create a Scanner for the file
            Scanner fileScanner = new Scanner(file);

            // Print out all the contents of the file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            // Close the Scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}