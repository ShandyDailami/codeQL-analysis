import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_22095_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {

        // Create a Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Get the file object for the directory
        File directory = new File(directoryPath);

        // Use a FileScanner to scan the directory
        File[] files = directory.listFiles();

        // Print out the names of the files
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}