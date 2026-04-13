import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_13741_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object that represents the current directory.
        File currentDir = new File(".");

        // Create a FilenameFilter that accepts only .txt files.
        FilenameFilter txtFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        // Use the File.list method to list all .txt files in the current directory.
        String[] txtFiles = currentDir.list(txtFilter);

        // Print the list of .txt files.
        System.out.println("The .txt files in the current directory are: " + Arrays.toString(txtFiles));
    }
}