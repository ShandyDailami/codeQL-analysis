import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34208_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Get the file to scan
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        // Check if the file is a directory
        if (file.isDirectory()) {
            System.out.println("Provided path is a directory, not a file.");
            return;
        }

        // Check if the file is readable
        if (!file.canRead()) {
            System.out.println("You do not have read permission for this file.");
            return;
        }

        // Check if the file is a text file
        if (!file.getName().endsWith(".txt")) {
            System.out.println("The provided path is not a text file.");
            return;
        }

        // Use FileScanner to read the file
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading the file.");
        }
    }
}