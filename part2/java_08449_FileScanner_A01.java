import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_08449_FileScanner_A01 {

    private static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("File: " + file.toString());
            byte[] byteBuffer = new byte[(int) file.getFileSize()];
            Files.readAllBytes(file, byteBuffer);
            System.out.println("File content: " + new String(byteBuffer));
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        File directory = new File("path_to_your_directory");
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + directory);
        }
        FileVisitor visitor = new FileVisitor();
        Files.walkFileTree(directory.toPath(), visitor);
    }
}