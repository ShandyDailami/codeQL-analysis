import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42008_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory
        File dir = new File("path/to/directory");

        // Create a Scanner object for the directory
        Scanner scanner = new Scanner(dir);

        // Print all files in the directory
        while (scanner.hasNextLine()) {
            String fileName = scanner.nextLine();
            File file = new File(fileName);

            // Print the file name
            System.out.println(file.getName());

            // Print the file path
            System.out.println(file.getPath());

            // Print the absolute path
            System.out.println(file.getAbsolutePath());

            // Print the file size in bytes
            System.out.println(file.length() + " bytes");
        }

        // Close the Scanner
        scanner.close();
    }
}