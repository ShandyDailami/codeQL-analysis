import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41671_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a scanner to read command line arguments
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();

        // Prompt the user for a filter
        System.out.println("Enter the filter (e.g., .txt):");
        String filter = scanner.nextLine();

        // Create a new File object
        File file = new File(directory);

        // Use the `listFiles` method to get a list of files in the directory
        File[] list = file.listFiles();

        // Iterate over the list of files
        for (File f : list) {
            // If the file name matches the filter, print its path
            if (f.getName().endsWith(filter)) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}