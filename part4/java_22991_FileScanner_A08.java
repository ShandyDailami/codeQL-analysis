import java.nio.file.*;

public class java_22991_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory)) {
            for (Path dir : dirs) {
                scanDirectory(dir);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void scanDirectory(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*.txt")) {
            for (Path file : files) {
                System.out.println(file.toAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}