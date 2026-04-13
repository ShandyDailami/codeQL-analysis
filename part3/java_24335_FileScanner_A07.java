import java.io.*;
import java.nio.file.*;

public class java_24335_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        // Initialize the file scanner
        FileScanner scanner = new FileScannerImpl();

        // Use the scanner to scan the file
        Path path = Paths.get("path_to_your_file");
        Files.walkFileTree(path, new SimpleFileVisitor<>(), 1);
    }
}

class FileScannerImpl implements FileScanner {
    @Override
    public void visitFile(Path file) throws IOException {
        // Print out the contents of the file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Override
    public void endDirectory(Path dir) throws IOException {
        // Do nothing, as we're only interested in the file system
    }

    @Override
    public void startDirectory(Path dir) throws IOException {
        // Do nothing, as we're only interested in the file system
    }
}

interface FileScanner {
    void visitFile(Path file) throws IOException;
    void endDirectory(Path dir) throws IOException;
    void startDirectory(Path dir) throws IOException;
}