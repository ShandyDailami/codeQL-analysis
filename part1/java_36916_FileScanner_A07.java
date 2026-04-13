import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_36916_FileScanner_A07 {

    private static final String DIR_PATH = "/path/to/your/directory";

    public static void main(String[] args) {
        scanDirectory(Paths.get(DIR_PATH));
    }

    public static void scanDirectory(Path directory) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    scanDirectory(path);
                } else {
                    // You can add security-sensitive operations here like checking file permissions, authentication, etc.
                    // For this example, we will just print the file name
                    System.out.println("File: " + path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}