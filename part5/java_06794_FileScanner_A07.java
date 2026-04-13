import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_06794_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("C:/Users/Public/");
        FileVisitor<Path> visitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().contains("AuthFailure")) {
                    System.out.println("File contains sensitive operation: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(path, visitor);
    }
}