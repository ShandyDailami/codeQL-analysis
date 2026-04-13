import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_34702_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        // Specify the directory to scan
        File directory = new File("your/directory/path");

        // Create a file filter to only match .txt files
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // If the file is a .txt file, return true
                return name.toLowerCase().endsWith(".txt");
            }
        };

        // Scan the directory for .txt files
        File[] txtFiles = directory.listFiles(filter);

        // Print out the names of the .txt files
        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        }
    }
}