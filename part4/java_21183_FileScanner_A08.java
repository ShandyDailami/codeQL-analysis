import java.io.*;
import java.nio.file.*;

public class java_21183_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("./src/main/resources");
            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileTime accessTime = Files.getLastModifiedTime(file);
                    FileTime modificationTime = Files.getLastModifiedTime(file);
                    FileTime creationTime = Files.getLastModifiedTime(file);

                    // Verify integrity by comparing last modified time
                    long lastModifiedTime = accessTime.toMillis();
                    long lastModifiedByModificationTime = modificationTime.toMillis();
                    long lastModifiedByCreationTime = creationTime.toMillis();

                    if (lastModifiedTime != lastModifiedByModificationTime ||
                        lastModifiedTime != lastModifiedByCreationTime) {
                        System.out.println("File integrity failure detected: " + file.toString());
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}