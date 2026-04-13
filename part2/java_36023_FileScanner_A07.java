import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_36023_FileScanner_A07 {

    private static final String DIRECTORY = "C:\\temp";

    public static void main(String[] args) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(DIRECTORY))) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    FileAttributes fileAttributes = Files.readAttributes(path, FileAttributes.class);
                    long size = fileAttributes.size();
                    if (size < 512) {
                        System.out.println("Small file: " + path);
                    } else {
                        System.out.println("Large file: " + path);
                    }
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}