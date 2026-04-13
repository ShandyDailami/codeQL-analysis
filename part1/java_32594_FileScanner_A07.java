import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32594_FileScanner_A07 {

    private static final String SEARCH_NAME = "auth_failure.txt";
    private static final String SEARCH_TYPE = "txt";

    public static void main(String[] args) {
        String rootDirectory = "/path/to/directory";
        scanDirectory(rootDirectory);
    }

    private static void scanDirectory(String directory) {
        File startingDirectory = new File(directory);
        File[] files = startingDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(SEARCH_NAME) && file.getPath().endsWith(SEARCH_TYPE)) {
                    System.out.println("File found: " + file.getPath());
                    return;
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        }
        System.out.println("File not found in: " + directory);
    }
}