import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.*;

public class java_11259_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get("./src");

        // Scan all directories under startingDirectory
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            // Visit all regular files, ignoring directories
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String fileName = file.getFileName().toString();
                if (fileName.endsWith(".txt")) {
                    // Security-sensitive operation here, e.g., check if the file contains a known injection vulnerability
                    if (containsInjectionVulnerability(file)) {
                        System.out.println("Security risk detected in file: " + fileName);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    // This is a placeholder for the actual implementation of the security-sensitive operation
    private static boolean containsInjectionVulnerability(Path file) {
        // Implementation depends on the specific requirements of the injection vulnerability detection algorithm
        // For simplicity, we'll assume that the file contents are read, and if it contains a specific pattern, it's an injection vulnerability
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("injection")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}