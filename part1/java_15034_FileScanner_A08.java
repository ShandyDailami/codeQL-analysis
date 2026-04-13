import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_15034_FileScanner_A08 {

    private static class ReadWriteVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!Files.isReadable(file) || !Files.isWritable(file)) {
                System.out.println("Warning: File " + file + " is not readable or not writable.");
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        File directory = new File("."); // Current directory
        Files.walkFileTree(directory.toPath(), new ReadWriteVisitor());
    }
}