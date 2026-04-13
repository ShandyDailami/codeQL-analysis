import java.io.IOException;
import java.nio.file.*;

public class java_03002_FileScanner_A01 {
    public static void main(String[] args) throws IOException,
            InvalidPathException {

        // Get the directory that we want to scan.
        Path dir = Paths.get("/path/to/directory");

        // Create a walker instance that will be used to traverse the directory
        // tree.
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(dir)) {
            // Walk over the directory tree.
            for (Path path : dirs) {
                // Only print directories.
                if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                } else {
                    // Only print .txt files.
                    if (Files.isRegularFile(path) && path.getFileName().toString().endsWith(".txt")) {
                        System.out.println("Text file: " + path);
                    }
                }
            }
        }
    }
}