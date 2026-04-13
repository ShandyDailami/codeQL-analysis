import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_16776_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("path/to/directory");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : directoryStream) {
                if (Files.isReadable(path)) {
                    processFile(path);
                } else {
                    System.out.println("Unable to read file: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void processFile(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Your code here to process the file content.
                // For example, print the line:
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + file);
        }
    }
}