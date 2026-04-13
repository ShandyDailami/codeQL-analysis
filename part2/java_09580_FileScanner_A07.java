import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_09580_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        // Get the current directory
        Path currentDir = Paths.get(".");

        // Use Files.newDirectoryStream to get a directory stream
        try (Stream<Path> paths = Files.newDirectoryStream(currentDir)) {
            // Use Streams.forEach to print each file path
            paths.forEach(System.out::println);
        }

        // Print out the count of files in the current directory
        System.out.println("Number of files: " + paths.count());
    }
}