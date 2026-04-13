import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30150_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory
        File directory = new File("path/to/directory");

        // Create a Scanner object to read the files
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file pattern: ");
        String pattern = scanner.nextLine();

        // Use the directory object and the pattern to find files
        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(pattern));

        // Print out the names of the matching files
        for (File file : matchingFiles) {
            System.out.println(file.getName());
        }
    }
}