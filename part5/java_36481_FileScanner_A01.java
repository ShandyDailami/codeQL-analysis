import java.io.File;
import java.util.List;

public class java_36481_FileScanner_A01 {
    public static void main(String[] args) {
        // Specify the directory path
        String directoryPath = "/path/to/directory";

        // Create a File object
        File directory = new File(directoryPath);

        // Use the listFiles() method to get a list of File objects for the directory
        File[] listOfFiles = directory.listFiles();

        // Check if listOfFiles is not null
        if (listOfFiles != null) {
            // Iterate through the list of files
            for (File file : listOfFiles) {
                // Check if the file is a file and not a directory
                if (file.isFile()) {
                    // Print the file name
                    System.out.println("File name: " + file.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}