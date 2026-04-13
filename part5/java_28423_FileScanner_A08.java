import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28423_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Scanner object for reading the input file
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the input file path
        System.out.println("Enter the path of the file to scan:");
        String filePath = scanner.nextLine();

        // Create a new File object for the given path
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
            // Create a new Scanner object for reading the file content
            Scanner fileScanner = new Scanner(file);

            // Scan the file and print each line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // Close the file scanner
            fileScanner.close();
        } else {
            System.out.println("File not found");
        }

        // Close the scanner
        scanner.close();
    }
}