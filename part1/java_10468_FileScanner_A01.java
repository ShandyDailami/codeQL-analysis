import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_10468_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "."; // The path to the directory to scan

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".java"); // Only accept .java files
                }
            });
            if (files != null) {
                Arrays.stream(files).forEach(FileScanner::scanFile);
            }
        }
    }

    private static void scanFile(File file) {
        System.out.println("Scanning file: " + file.getPath());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}