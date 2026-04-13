import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_21668_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File rootDir = new File("."); // Current directory

        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        };

        rootDir.setReadonly(false);
        rootDir.visitFileTree(visitor);
    }
}