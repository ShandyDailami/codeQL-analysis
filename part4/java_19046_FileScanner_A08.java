import java.io.IOException;
import java.nio.file.*;

public class java_19046_FileScanner_A08 {

    private static final PathMatcher<Path> FILE_FILETCHER = FileSystems.getDefault().getPathMatcher("glob:*.txt");

    public static void main(String[] args) {
        Path startingDirectory = Paths.get("src/main/java");
        try {
            Files.walkFileTree(startingDirectory, FILE_FILETCHER)
                    .forEach(fileScanner -> checkAndProcessFile(fileScanner));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkAndProcessFile(Path file) {
        if (file.toString().endsWith("A08_IntegrityFailure")) {
            System.out.println("Integrity failure detected in file: " + file.toString());
            // Placeholder for more complex operation.
            // For instance, delete the file.
            // Files.delete(file);
        }
    }
}