import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_41021_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get("./src");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getName().startsWith(".") || file.toString().endsWith(".class")) {
                    return FileVisitResult.CONTINUE;
                }
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}