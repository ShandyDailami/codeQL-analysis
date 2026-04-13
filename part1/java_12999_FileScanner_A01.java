import java.io.File;
import java.io.FilenameFilter;

public class java_12999_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String searchPattern = "*.txt"; // replace with your search pattern

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(searchPattern);
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with pattern: " + searchPattern);
        }
    }
}