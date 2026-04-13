import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10392_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(".", ".*security.*");
    }
}

class FileScanner {
    public void scanDirectory(String directoryPath, String filter) {
        File directory = new File(directoryPath);
        File[] directoryContents = directory.listFiles();

        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isFile() && file.getName().contains(filter)) {
                    System.out.println("Security-Sensitive file found: " + file.getAbsolutePath());
                }
            }
        }
    }
}