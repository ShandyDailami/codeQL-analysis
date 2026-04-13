import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_32360_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "C:\\Windows"; // replace with your directory path
        File directory = new File(directoryPath);

        // Create a FileFilter that only accepts .txt files
        FilenameFilter txtFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        // Use the listFiles method of the File class to get a list of files in the directory
        File[] txtFiles = directory.listFiles(txtFilter);

        if (txtFiles != null) {
            // Print the names of the .txt files
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getName());
            }
        } else {
            System.out.println("No .txt files found in " + directoryPath);
        }
    }
}