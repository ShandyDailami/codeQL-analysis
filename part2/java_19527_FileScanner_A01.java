import java.io.File;
import java.io.FilenameFilter;

public class java_19527_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        String filterPattern = ".*txt"; // replace with your file type filter
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(filterPattern);
            }
        };

        File[] txtFiles = directory.listFiles(filenameFilter);
        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No text files found in the directory.");
        }
    }
}