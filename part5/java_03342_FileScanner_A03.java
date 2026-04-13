import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_03342_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        SecurityFileScanner scanner = new SecurityFileScanner();
        scanner.scan(path, scanner);
    }

    public void scan(Path path, SecurityFileScanner scanner) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file : stream) {
                if (Files.isDirectory(file)) {
                    scan(file, scanner);
                } else {
                    scanFile(file, scanner);
                }
            }
        }
    }

    private void scanFile(Path file, SecurityFileScanner scanner) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Scan line for known injection attempts
                if (line.contains("password") || line.contains("username") || line.contains("secret")) {
                    System.out.println("Detected security-sensitive operation related to injection");
                    // If line contains a known injection attempt, don't print the file name
                    return;
                }
            }
        }
        System.out.println("No security-sensitive operations found in file: " + file.toString());
    }
}