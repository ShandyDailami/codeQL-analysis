import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13963_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new File object representing the directory to be scanned.
        File directory = new File(".");

        // Create a new FileScanner object for the directory.
        FileScanner scanner = new FileScanner(directory);

        // Use a Scanner to read the file names from the directory.
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to search for:");
        String fileName = input.next();

        // Use the FileScanner's methods to find the file in the directory.
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        }

        // Close the Scanner.
        input.close();
    }
}