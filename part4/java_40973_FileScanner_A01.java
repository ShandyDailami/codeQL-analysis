import java.io.*;
import java.nio.file.*;

public class java_40973_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        String directoryPath = "path/to/directory";

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path dir : dirs) {
                if (Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
                    System.out.println("Directory: " + dir.toString());
                    processDirectory(dir);
                } else {
                    System.out.println("File: " + dir.toString());
                    processFile(dir);
                }
            }
        }
    }

    private static void processDirectory(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, FileAttributes.class)) {
            for (Path file : files) {
                if (Files.isReadable(file)) {
                    System.out.println("Reading: " + file.toString());
                    // process file...
                } else {
                    System.out.println("Skipping read-restricted file: " + file.toString());
                }
            }
        }
    }

    private static void processFile(Path file) {
        try (InputStream is = Files.newInputStream(file)) {
            System.out.println("Reading: " + file.toString());
            // process file...
        } catch (IOException e) {
            System.out.println("Failed to read file: " + file.toString());
        }
    }
}