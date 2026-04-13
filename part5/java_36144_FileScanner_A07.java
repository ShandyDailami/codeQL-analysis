import java.nio.file.*;
import java.util.stream.*;

public class java_36144_FileScanner_A07 {

    private static final String PASSWORD = "your_password_here";

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/start/search"))) {
            paths.filter(matcher::matches).map(SecurityScanner::newFileReadable).forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static boolean newFileReadable(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file, StandardOpenOption.READ)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(PASSWORD)) {
                    System.out.println("Encountered password-protected file: " + file.toString());
                    return false;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error reading file: " + file.toString());
        }
        return true;
    }
}