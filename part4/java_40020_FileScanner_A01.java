import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_40020_FileScanner_A01 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("your_directory_path"); // replace with your directory path

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("File: " + file.toString() + ", Size: " + Files.size(file));
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}