import java.nio.file.*;

public class java_12569_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("."); // starting from the current directory
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
            for (Path dir : dirs) {
                if (Files.isDirectory(dir)) {
                    System.out.printf("Directory: %s%n", dir);
                    try (DirectoryStream<Path> files = Files.newDirectoryStream(dir)) {
                        for (Path file : files) {
                            System.out.printf("   File: %s%n", file);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }
}