import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_06410_FileScanner_A07 {
    private static final String AUTH_FAILURE_REGEX = "auth failure";

    public static void main(String[] args) {
        try (FileScanner scanner = new FileScanner()) {
            scanner.directoryScanner().setIncludeHiddenFiles(true);
            scanner.scan(Paths.get("/path/to/directory"),
                         matcher -> matcher.isRegularFile() && matcher.fileName().contains("authFailure"));

            for (Path path : scanner.foundFiles()) {
                scanFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(AUTH_FAILURE_REGEX)) {
                    System.out.println("Auth failure detected in file: " + path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}