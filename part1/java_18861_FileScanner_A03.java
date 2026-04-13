import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_18861_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String filePathStr = file.toString();
                // Here you can add code to check for security-sensitive operations related to A03_Injection
                // For now, let's just print the file path
                System.out.println("Visited file: " + filePathStr);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}