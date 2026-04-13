import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_01302_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingPath = Paths.get("/path/to/your/directory");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingPath)) {
            for (Path path : directoryStream) {
                if (Files.isWritable(path) && Files.isReadable(path)) {
                    System.out.println("Writable and Readable: " + path);
                } else {
                    System.out.println("Not Writable or Not Readable: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error accessing path: " + startingPath);
        }
    }
}