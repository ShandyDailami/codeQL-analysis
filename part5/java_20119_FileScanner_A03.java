import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_20119_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Define a FileFilter to filter out .txt files
        FilenameFilter textFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        // Use the listFiles method to get a list of all .txt files in the directory
        File[] txtFiles = directory.listFiles(textFilter);

        // Check if there are any .txt files
        if (txtFiles == null || txtFiles.length == 0) {
            System.out.println("No .txt files found in the directory");
            return;
        }

        // Print out the list of .txt files
        System.out.println("The following .txt files are in the directory:");
        for (File file : txtFiles) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}