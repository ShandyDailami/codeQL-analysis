import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_18041_FileScanner_A07 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(".");
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found text file: " + file);
                    // TODO: Handle the file, potentially reading the contents and
                    // executing security-sensitive operations related to A07_AuthFailure.
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}