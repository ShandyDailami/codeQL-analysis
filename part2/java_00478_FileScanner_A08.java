import java.io.IOException;
import java.nio.file.*;

public class java_00478_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        // Create a file scanner that walks the directory tree starting from the current directory.
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : dirs) {
                // Get the file name.
                String fileName = path.getFileName().toString();

                // Now, let's assume we are scanning a directory for files with specific names.
                // If the file name matches, print a message.
                if (fileName.contains("sensitive")) {
                    System.out.println("Found sensitive file: " + fileName);
                }
            }
        }
    }
}