import java.io.IOException;
import java.nio.file.*;

public class java_31873_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/path/to/directory"); // replace with your directory path

        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Check for the specific security-sensitive operation here
                // For example, check if the file is readable and writeable,
                // or if it's a binary file and has the necessary permissions
                if (Files.isReadable(file) && Files.isWritable(file)) {
                    // If the file passes the checks, process it
                    System.out.println("Processing file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}