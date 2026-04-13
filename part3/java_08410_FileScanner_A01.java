import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_08410_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        String directoryPath = args[0];
        Files.walkFileTree(Paths.get(directoryPath), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Print out the file name
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}