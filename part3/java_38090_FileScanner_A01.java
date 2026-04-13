import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_38090_FileScanner_A01 {

    private static class FileVisitorImpl extends SimpleFileVisitor<Path> {

        private static final String SENSITIVE_FILE = "sensitive_file.txt";

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.getFileName().toString().equals(SENSITIVE_FILE)) {
                System.out.println("Detected sensitive file: " + file.toString());
                // Perform security-sensitive operations here...
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        FileVisitor visitor = new FileVisitorImpl();
        Files.walkFileTree(directory.toPath(), visitor);
    }
}