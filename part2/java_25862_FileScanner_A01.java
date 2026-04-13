import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_25862_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object to represent the directory to be scanned.
        File directory = new File(".");

        // Create a FileFilter object to filter files.
        FilenameFilter filter = (dir, name) -> name.endsWith(".java");

        // Use the File's list method to get a list of all file names in the directory
        // that meet the FileFilter's condition.
        String[] list = directory.list(filter);

        // If there are no files that meet the condition, print a message and exit.
        if (list == null) {
            System.out.println("No Java source files found in the current directory.");
            System.exit(0);
        }

        // Sort the list of file names.
        Arrays.sort(list);

        // Scan each file name.
        for (String fileName : list) {
            // Create a new File object for the file.
            File file = new File(fileName);

            // Use a Scanner to read and print the contents of the file.
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
    }
}