import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_37916_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                // This method is called for each file.
                // Check for security-sensitive operations.
                // For this example, we'll just print out the file name.
                if (file.toString().contains("sensitive")) {
                    System.out.println("Found sensitive file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };
        try {
            Files.walkFileTree(startingDirectory, fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}