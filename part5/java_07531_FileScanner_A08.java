import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07531_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("path/to/directory", "string");
    }
}

class FileScanner {
    public void scanDirectory(String directoryPath, String searchString) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            if (scanner.nextLine().contains(searchString)) {
                                System.out.println("File: " + file.getName());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}