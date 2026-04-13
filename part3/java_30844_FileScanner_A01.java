import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.*;

public class java_30844_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingPath = Paths.get(".").toAbsolutePath();
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingPath, "*.txt")) {
            for (Path path : dirStream) {
                BasicFileAttributes attrs;
                try {
                    attrs = Files.readAttributes(path, BasicFileAttributes.class);
                } catch (IOException e) {
                    System.err.println("Couldn't read attributes for " + path);
                    continue;
                }

                System.out.println(path.toString());

                // Let's try to access a file in a subdirectory
                Path subdir = path.getParent().resolve("subdir");
                try (DirectoryStream<Path> subdirStream = Files.newDirectoryStream(subdir, "*.txt")) {
                    for (Path subpath : subdirStream) {
                        System.out.println("   trying to access: " + subpath);
                    }
                } catch (IOException e) {
                    System.err.println("Couldn't access " + subdir + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Couldn't list directory contents: " + e.getMessage());
        }
    }
}