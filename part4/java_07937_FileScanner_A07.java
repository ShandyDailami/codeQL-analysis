import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_07937_FileScanner_A07 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().equals("A07_AuthFailure")) {
                    System.out.println("File found: " + file.toAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(start, fileVisitor);
    }
}