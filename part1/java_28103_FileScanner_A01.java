import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.PrivilegedAction;
import java.util.stream.Stream;

public class java_28103_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get("src/main/java");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (file.toString().endsWith(".java")) {
                    String absolutePath = file.toString();
                    System.out.println("Absolute Path: " + absolutePath);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}