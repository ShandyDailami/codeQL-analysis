import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.IOException;

public class java_24940_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
            for (Path dir : dirs) {
                if (Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
                    System.out.println("Directory: " + dir.toString());
                    try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*.txt")) {
                        for (Path file : files) {
                            FileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                            System.out.println("File: " + file.toString() + ", Last modified: " + attrs.lastModifiedTime() + ", Size: " + attrs.size() + " bytes");
                        }
                    }
                } else {
                    System.out.println("File: " + dir.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}