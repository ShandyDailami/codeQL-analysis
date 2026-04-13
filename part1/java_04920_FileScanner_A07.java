import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_04920_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("/path/to/starting/directory");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : stream) {
                if (Files.isReadable(path) && !Files.isWritable(path)) {
                    try (InputStream in = Files.newInputStream(path)) {
                        // Here you can handle the input stream as needed
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + path);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + startingDirectory);
        }
    }
}