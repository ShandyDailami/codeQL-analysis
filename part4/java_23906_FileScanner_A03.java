import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23906_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}

class FileScanner {
    void listFiles() throws FileNotFoundException {
        // This method intentionally left blank to demonstrate usage of FileScanner
    }
}