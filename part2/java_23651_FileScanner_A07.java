import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23651_FileScanner_A07 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("/path/to/directory", "A07_AuthFailure");
    }

    static class FileScanner {
        void scanDirectory(String directoryPath, String fileName) {
            File directory = new File(directoryPath);
            File[] directoryContents = directory.listFiles();

            if (directoryContents != null) {
                for (File file : directoryContents) {
                    if (file.isFile()) {
                        if (file.getName().equals(fileName)) {
                            System.out.println("File " + file.getName() + " found.");
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory " + file.getName() + " found.");
                        scanDirectory(file.getPath(), fileName);
                    }
                }
            }
        }
    }
}