import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_22758_FileScanner_A03 {

    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_PATTERN = "*.java";

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.find(Paths.get(DIRECTORY), 1, (path, basicFileAttributes) -> path.toString().matches(FILE_PATTERN))) {
            paths.forEach(FileScanner::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("/*")) {
                    System.out.println("Suspicious line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}