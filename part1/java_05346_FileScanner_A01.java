import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class java_05346_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File rootDir = new File("/path/to/root/directory");
        visitDirectory(rootDir);
    }

    private static void visitDirectory(File dir) throws IOException {
        Files.walkFileTree(dir.toPath(), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    // This is a security-sensitive operation.
                    // Here we are just printing the file name.
                    // Depending on your specific use case, you may want to implement a more complex security check.
                    System.out.println("Security-sensitive operation: Access to " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}