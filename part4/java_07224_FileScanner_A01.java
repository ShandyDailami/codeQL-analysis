import java.nio.file.*;
import java.util.*;

public class java_07224_FileScanner_A01 {
    public static void main(String[] args) {
        Path startPath = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startPath)) {
            paths.forEach(FileScanner::processFile);
        } catch (IOException e) {
            System.err.println("Failed to walk directory: " + e.getMessage());
        }
    }

    private static void processFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            // Add your processing logic here
            // This is just a placeholder. Remove this part to stop the program.
            Scanner s = new Scanner(in);
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Failed to read file: " + file + e.getMessage());
        }
    }
}