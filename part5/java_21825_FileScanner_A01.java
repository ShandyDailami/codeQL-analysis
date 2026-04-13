import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21825_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory to scan
        File directory = new File(".");

        // Create a scanner to read files in the directory
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a file name
        System.out.print("Enter the name of a file to read: ");
        String fileName = scanner.next();

        // Create a File object for the file to read
        File file = new File(directory, fileName);

        // Create a scanner to read the file
        Scanner fileScanner = new Scanner(file);

        // Read and print the contents of the file
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }

        // Close the file scanner
        fileScanner.close();
    }
}