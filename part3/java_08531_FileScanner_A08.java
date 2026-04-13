import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_08531_FileScanner_A08 {
    private static final String DIRECTORY_PATH = "/path/to/directory";

    public static void main(String[] args) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(DIRECTORY_PATH))) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    System.out.println("Directory: " + path);
                } else {
                    File file = path.toFile();
                    System.out.println("File: " + file.getName());
                    long size = Files.size(path);
                    System.out.println("Size: " + size + " bytes");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}