import java.io.File;
import java.util.Arrays;

public class java_18588_FileScanner_A07 {
    public static void main(String[] args) {
        // Define the directory
        String directoryPath = "/path/to/your/directory";

        // Create a File object to represent the directory
        File directory = new File(directoryPath);

        // Check if the directory exists and is accessible
        if (directory.exists() && directory.isDirectory()) {
            // List all files in the directory
            File[] files = directory.listFiles();

            // Check if the directory is not empty
            if (files != null && files.length > 0) {
                // Sort the files by name
                Arrays.sort(files, (file1, file2) -> file1.getName().compareTo(file2.getName()));

                // Print out the sorted list of files
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The directory does not exist or is not accessible.");
        }
    }
}