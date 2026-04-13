import java.io.File;
import java.io.FileFilter;

public class java_03424_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new File object representing the directory to be scanned.
        File directory = new File("C:\\path\\to\\directory");

        // Create a new FileFilter object that only accepts files ending with '.txt'.
        FileFilter txtFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // List all files in the directory that match the FileFilter.
        File[] txtFiles = directory.listFiles(txtFilter);
        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("File: " + txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found in directory.");
        }
    }
}