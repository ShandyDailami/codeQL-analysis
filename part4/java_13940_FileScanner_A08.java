import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_13940_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "C:\\Windows";
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : dirs) {
                File file = path.toFile();
                if (file.isFile()) {
                    long timestamp = file.lastModified();
                    if (timestamp < 0) {
                        System.out.println("Failed to get last modified time for file: " + file.getName());
                    } else {
                        System.out.println("Last modified time for file: " + file.getName() + " = " + new Date(timestamp));
                    }
                } else {
                    System.out.println("Skipping directory: " + file.getName());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}