import java.nio.file.*;
import java.util.stream.*;

public class java_38066_FileScanner_A01 {
    public static void main(String[] args) {
        // Specify the directory and the file extension
        Path dir = Paths.get(".");
        String extension = ".txt";

        try (Stream<Path> paths = Files.walk(dir)) {
            // Filter files by extension
            paths.filter(path -> path.toString().endsWith(extension))
                .forEach(BrokenAccessControl::processFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void processFile(Path file) {
        try {
            // Read and print the contents of the file
            Files.lines(file).forEach(System.out::println);
        } catch (Exception ex) {
            // Handle any possible exceptions
            ex.printStackTrace();
        }
    }
}