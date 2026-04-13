import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_19950_FileScanner_A01 {

    // Main method
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Create a FileFilter for text files
        FileFilter textFilesFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use the filter to find text files in the directory
        File[] textFiles = directory.listFiles(textFilesFilter);

        if (textFiles != null) {
            for (File textFile : textFiles) {
                System.out.println("Text file: " + textFile.getAbsolutePath());
            }
        } else {
            System.out.println("No text files found in directory: " + directoryPath);
        }
    }
}