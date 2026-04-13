import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_22096_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String SECURITY_REGEX = "(?i)security";

    public static void main(String[] args) {
        try (Stream<Path> directoryStream = Files.walk(Paths.get(DIRECTORY))) {
            directoryStream.forEach(FileScannerExample::searchForSecurity);
        } catch (IOException e) {
            System.err.println("Error walking the directory tree.");
            e.printStackTrace();
        }
    }

    private static void searchForSecurity(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(SECURITY_REGEX)) {
                    System.out.printf("Found security-sensitive operation in file: %s%n", path);
                }
            }
        } catch (IOException e) {
            System.err.printf("Error reading file: %s%n", path);
            e.printStackTrace();
        }
    }
}