import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_22806_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("/path/to/directory");
    }

    public static class FileScanner {
        private static final int MAX_FILE_SIZE = 500; // define your max file size here
        private static final String DIRECTORY_PATH = "/path/to/directory"; // define your directory path here

        public void startScanning(String directoryPath) throws IOException {
            File directory = new File(directoryPath);
            File[] foundFiles = directory.listFiles((dir, name) -> {
                File file = new File(dir, name);
                return file.length() > MAX_FILE_SIZE;
            });

            if (foundFiles != null) {
                for (File file : foundFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getPath());
                    } else {
                        System.out.println("Directory: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        }
    }
}