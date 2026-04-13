import java.nio.file.*;
import java.io.*;

public class java_16781_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("."); // replace with the directory you want to scan

        // Ensure the directory exists and is readable
        if (!Files.exists(dir)) {
            System.out.println("Directory does not exist");
            return;
        }
        if (!Files.isReadable(dir)) {
            System.out.println("Directory is not readable");
            return;
        }

        // Scan the directory for files
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Get the file name
                String fileName = file.toString();
                System.out.println("Scanning file: " + fileName);

                // Add your code here to handle the file. This could be anything from processing the file, reading from it, etc.

                return FileVisitResult.CONTINUE;
            }
        });
    }
}