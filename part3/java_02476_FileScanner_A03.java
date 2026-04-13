import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_02476_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a File object for the directory we want to scan
        File dir = new File(".");

        // Create a FileFilter that only accepts files that end with ".txt"
        FileFilter txtFiles = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        // Use the File object's list method to list all files in the directory
        // that match the FileFilter
        File[] txtFilesInDir = dir.listFiles(txtFiles);

        // Print out the file names
        for (File txtFile : txtFilesInDir) {
            System.out.println(txtFile.getName());
        }
    }
}