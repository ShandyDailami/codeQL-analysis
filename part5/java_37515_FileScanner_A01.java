import java.io.File;
import java.util.Scanner;

public class java_37515_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("./src/main/resources", ".txt");
    }
}

class FileScanner {
    public void scanDirectory(String directoryPath, String extension) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files in directory");
        }
    }
}