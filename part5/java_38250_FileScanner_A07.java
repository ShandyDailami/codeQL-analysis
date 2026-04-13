import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_38250_FileScanner_A07 {

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // Check if the file is a directory or a regular file
            if (file.toFile().isFile()) {
                // Check if the file is a sensitive file
                if (file.toFile().getName().endsWith(".sensitive")) {
                    System.out.println("Found a sensitive file: " + file);
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        // Create a FileVisitor that will visit files
        MyFileVisitor myFileVisitor = new MyFileVisitor();

        // Start the file visit
        java.nio.file.Files.walkFileTree(java.nio.file.Paths.get("/path/to/your/directory"), myFileVisitor);
    }
}