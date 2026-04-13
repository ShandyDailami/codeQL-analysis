import java.io.File;
import java.io.FileFilter;

public class java_20970_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory

        // Create FileFilter that filters for files with .txt extension
        FileFilter txtFiles = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // List all txt files in current directory
        File[] txtFilesList = directory.listFiles(txtFiles);
        if (txtFilesList != null) {
            for (File txtFile : txtFilesList) {
                System.out.println(txtFile.getAbsolutePath());
            }
        }
    }
}