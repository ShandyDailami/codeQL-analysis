import java.io.File;
import java.io.FileFilter;

public class java_36292_FileScanner_A08 {

    public static void main(String[] args) {
        // Provide a directory path
        String directoryPath = "/path/to/directory";

        // Create a File object
        File directory = new File(directoryPath);

        // Create a FileFilter that filters only directories
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // Scan the directory for all files
        File[] foundFiles = directory.listFiles(fileFilter);

        // If foundFiles is not null, print the names of the files
        if (foundFiles != null) {
            for (File file : foundFiles) {
                System.out.println(file.getName());
            }
        }
    }
}