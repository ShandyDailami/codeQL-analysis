import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_38768_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory

        // Define a filter that will only accept .txt files
        FileFilter txtFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use the FileFilter to find all .txt files in the directory
        File[] txtFiles = directory.listFiles(txtFilter);

        // Check if no files were found
        if (txtFiles == null) {
            System.out.println("No .txt files found in the current directory.");
            return;
        }

        // Print all found files
        Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
    }
}