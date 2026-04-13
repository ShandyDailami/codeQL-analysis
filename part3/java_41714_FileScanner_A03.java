import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41714_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File instance for a directory
        File dir = new File("path_to_directory");

        // Create a Scanner instance for reading files
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a file name
        System.out.println("Enter a file name: ");
        String fileName = scanner.next();

        // Construct a File instance for the user-provided file name
        File file = new File(dir, fileName);

        // Check if the file exists
        if (file.exists()) {
            // Create a Scanner instance for reading file content
            Scanner fileScanner = new Scanner(file);

            // Print the content of the file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            // Close the Scanner
            fileScanner.close();
        } else {
            System.out.println("File does not exist!");
        }
    }
}