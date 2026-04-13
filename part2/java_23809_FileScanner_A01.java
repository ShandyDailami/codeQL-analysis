import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_23809_FileScanner_A01 {
    private static final String DIRECTORY = "src";
    private static final String EXTENSION = "java";
    private static final Set<String> SECURITY_FAILURES = new HashSet<>();

    public static void main(String[] args) throws Exception {
        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(DIRECTORY))) {
            paths.forEach(SecurityScanner::checkFile);
        }

        if (!SECURITY_FAILURES.isEmpty()) {
            System.out.println("The following files were found to contain security issues:");
            for (String failure : SECURITY_FAILURES) {
                System.out.println(failure);
            }
        } else {
            System.out.println("All files are safe from security issues!");
        }
    }

    private static void checkFile(Path path) {
        if (Files.isDirectory(path) || !path.toString().endsWith("." + EXTENSION)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("password")) {
                    SECURITY_FAILURES.add(path.toString());
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + path);
        }
    }
}