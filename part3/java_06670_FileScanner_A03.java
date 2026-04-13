import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_06670_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/path/to/your/directory");

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitResult result;

                String filename = file.toString();

                // Security-sensitive operations related to A03_Injection
                // ...

                // Continue walking the directory tree
                result = super.visitFile(file, attrs);

                // Security-sensitive operations related to A03_Injection
                // ...

                return result;
            }
        });
    }
}