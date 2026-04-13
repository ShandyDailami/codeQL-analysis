import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

public class java_04688_FileScanner_A01 {
    public static void main(String[] args) {
        // Define the directory to scan
        String directory = "C:/path/to/directory";

        // Use a FileFilter that accepts only directories
        FileFilter dirFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // Scan the directory and print out the names of the text files
        File[] foundFiles = new File(directory).listFiles(dirFilter);
        if (foundFiles != null) {
            for (File file : foundFiles) {
                System.out.println(file.getName());
            }
        }
    }
}