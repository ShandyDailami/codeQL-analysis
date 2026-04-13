import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04048_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the directory path from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        // Get the file name filter from the user
        System.out.print("Enter file name filter: ");
        String fileFilter = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Create a file filter
        FilenameFilter filter = (dir, name) -> name.endsWith(fileFilter);

        // List the files in the directory
        File[] txtFiles = directory.listFiles(filter);

        // Print the file names
        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the directory");
        }
    }
}