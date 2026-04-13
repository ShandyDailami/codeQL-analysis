import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_30008_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String searchText = "search_text.txt";

        File startingDirectory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equalsIgnoreCase(searchText);
            }
        };

        secureFileSearch(startingDirectory, fileFilter);
    }

    public static void secureFileSearch(File startingDirectory, FileFilter fileFilter) {
        File[] foundFiles = startingDirectory.listFiles(fileFilter);

        if (foundFiles != null) {
            Arrays.stream(foundFiles).forEach(file -> {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getPath());
                    // Implement security-sensitive operations here (e.g., reading the file, executing commands, etc.)
                } else if (file.isDirectory()) {
                    System.out.println("Found directory: " + file.getPath());
                    // Implement security-sensitive operations here (e.g., reading the directory, executing commands, etc.)
                    secureFileSearch(file, fileFilter);
                }
            });
        }
    }
}