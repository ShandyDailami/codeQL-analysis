import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_00819_FileScanner_A07 {

    private static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // Print file name
            System.out.println(file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            // Handle exception
            System.out.println("Failed to visit file: " + file);
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        try {
            Files.walkFileTree(rootDirectory.toPath(), new FileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}