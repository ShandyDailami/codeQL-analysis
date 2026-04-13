import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_41870_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/dir"; // replace with your directory path
    private static final String FILE_EXTENSION = ".*\\.java"; // replace with the file extension

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(DIR_PATH), "*.java")) {
            for (Path path : paths) {
                File file = path.toFile();
                if (file.canExecute() && file.exists()) {
                    // Security-sensitive operations related to A07_AuthFailure
                    // ...

                    // print the file name
                    System.out.println("File name: " + file.getName());

                    // ...

                    // continue with your other operations
                    // ...
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}