import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.*;

public class java_32365_FileScanner_A07 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path dir : dirs) {
                FileTime lastModified = Files.getLastModifiedTime(dir);
                System.out.println("File: " + dir.toString() + ", Last modified: " + lastModified);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}