import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_29461_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\path_to_directory"); // replace with your directory path
        Files.walkFileTree(path, new FileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                long size = Files.size(file);
                if (size > 1000) {
                    System.out.println("Large file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("Unable to access: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("Visiting directory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}