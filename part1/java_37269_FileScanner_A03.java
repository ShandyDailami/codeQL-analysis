import java.io.File;
import java.util.Arrays;

public class java_37269_FileScanner_A03 {

    public static void main(String[] args) {
        // Specify your directory here
        String directory = "/path/to/your/directory";

        FileScanner(directory);
    }

    public static void FileScanner(String directory) {
        File[] foundFiles;

        // Get a list of all files in the directory
        foundFiles = new File(directory).listFiles();

        // Ensure that we got some files
        if (foundFiles == null) {
            System.out.println("No files found in directory: " + directory);
            return;
        }

        // Iterate over the list of files
        for (File file : foundFiles) {
            // We only want files, not directories
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}