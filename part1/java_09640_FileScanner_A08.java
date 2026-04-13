import java.io.*;
import java.nio.file.*;
import java.security.InvalidParameterException;
import java.util.stream.*;

public class java_09640_FileScanner_A08 {
    private static final Path startingDirectory = Paths.get("C:/temp");

    public static void main(String[] args) {
        try {
            scanDirectory(startingDirectory);
        } catch (InvalidParameterException e) {
            System.err.println("Invalid parameters: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error accessing directory: " + e.getMessage());
        }
    }

    private static void scanDirectory(Path directory) throws IOException, InvalidParameterException {
        if (!Files.exists(directory)) {
            throw new InvalidParameterException("The specified directory does not exist.");
        }

        if (!Files.isDirectory(directory)) {
            throw new InvalidParameterException("The specified path is not a directory.");
        }

        try (Stream<Path> entries = Files.list(directory).parallel()) {
            entries.forEach(file -> {
                try {
                    if (Files.isDirectory(file)) {
                        scanDirectory(file);
                    } else {
                        checkFileIntegrity(file);
                    }
                } catch (IOException e) {
                    System.err.println("Error accessing file: " + e.getMessage());
                }
            });
        }
    }

    private static void checkFileIntegrity(Path file) throws IOException {
        // Your implementation here. For simplicity, we assume that the integrity check can be done by reading the first 512 bytes.
        try (InputStream in = Files.newInputStream(file)) {
            byte[] buffer = new byte[512];
            int bytesRead = in.read(buffer);
            if (bytesRead != buffer.length) {
                throw new IOException("Error reading file: Not enough bytes read.");
            }
        }

        // Assuming the file is valid if the integrity check passed.
        System.out.println("File " + file.getFileName() + " is valid.");
    }
}