import java.io.File;
import java.io.FilenameFilter;

public class java_16174_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "."; // The directory where the search starts.
        String searchPattern = "A*"; // The pattern to search for.

        File directory = new File(directoryPath);

        // Use a filter to search only files with a length greater than 100 characters.
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir.getAbsolutePath() + "/" + name);
                return file.isFile() && file.length() > 100;
            }
        };

        String[] files = directory.list(filenameFilter);

        if (files != null) {
            for (String fileName : files) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No files found.");
        }
    }
}