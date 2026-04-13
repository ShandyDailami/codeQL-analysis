import java.nio.file.*;
import java.util.*;
import java.nio.file.attribute.*;

public class java_22079_FileScanner_A03 {

    public static void main(String[] args) {
        Path path = Paths.get("."); // Let's start from the current directory
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
            for (Path dir : dirs) {
                scanDirectory(dir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanDirectory(Path dir) throws IOException {
        System.out.println("Scanning directory: " + dir.toString());
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir)) {
            for (Path file : files) {
                if (Files.isRegularFile(file)) {
                    System.out.println("  File: " + file.toString());
                    // Here you could add the code to scan the file for injection attempts
                    // But remember, we are only scanning directory and not the files themselves
                } else if (Files.isDirectory(file)) {
                    System.out.println("  Directory: " + file.toString());
                    scanDirectory(file);
                }
            }
        }
    }
}