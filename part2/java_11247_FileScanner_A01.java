import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11247_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("/path/to/directory");
    }
}

class FileScanner {
    public void scanDirectory(String path) {
        File directory = new File(path);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Directory is empty");
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file.getAbsolutePath());
            } else {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        }
    }
}