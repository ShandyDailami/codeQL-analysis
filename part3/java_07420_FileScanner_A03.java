import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.*;

public class java_07420_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("path/to/directory");

        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                long size = Files.size(file);

                if (size > 1000) {
                    System.out.println("File: " + file.toString() + ", Size: " + size);
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }
}