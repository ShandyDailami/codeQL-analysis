import java.nio.file.*;

public class java_13065_FileScanner_A08 {

    public static void main(String[] args) {
        Path startingPath = Paths.get(".").toAbsolutePath();
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingPath, "*.txt")) {
            for (Path path : dirs) {
                FileTime fileTime = Files.getLastModifiedTime(path);
                System.out.println(fileTime + ": " + path);
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}