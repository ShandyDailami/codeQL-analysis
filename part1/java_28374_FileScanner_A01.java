import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28374_FileScanner_A01 {

    private static final String DIRECTORY = "C:\\path\\to\\directory";
    private static final String SECURITY_PATTERN = "S01_Security";

    public static void main(String[] args) {
        try {
            File directory = new File(DIRECTORY);
            searchInDirectory(directory);
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the directory: " + e.getMessage());
        }
    }

    private static void searchInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchInDirectory(file);
                } else if (file.getName().contains(SECURITY_PATTERN)) {
                    System.out.println("Security-sensitive operation detected in file: " + file.getPath());
                }
            }
        }
    }
}