import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23944_FileScanner_A08 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("your_directory_path");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().equals("specific_file.txt")) {
                    System.out.println("File found: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}