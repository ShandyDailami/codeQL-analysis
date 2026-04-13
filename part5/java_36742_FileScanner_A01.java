import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class java_36742_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // Replace with the path of the directory you want to scan
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) throws IOException {
        File dir = new File(directoryPath);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // This is a file. Accessing a file in this context is a security-sensitive operation.
                    readFile(file.getPath());
                } else if (file.isDirectory()) {
                    // This is a directory. Accessing a directory in this context is a security-sensitive operation.
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    private static void readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.readAllLines(path);
        // This operation is not security-sensitive.
    }
}