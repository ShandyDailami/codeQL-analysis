import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_02331_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "/path/to/directory"; // replace with your directory path

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        // Define the file filter
        FileFilter textFilesFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Return true if the file is a .txt file
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use the file filter to find all .txt files in the directory
        File[] textFiles = directory.listFiles(textFilesFilter);

        // If no .txt files found, print a message
        if (textFiles == null) {
            System.out.println("No .txt files found in the specified directory");
        } else {
            // Otherwise, print the names of all .txt files
            Arrays.stream(textFiles).forEach(file -> System.out.println(file.getName()));
        }
    }
}