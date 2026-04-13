import java.nio.file.*;

public class java_16940_FileScanner_A07 {
    public static void main(String[] args) {
        Path dir = Paths.get(".");  // Get the current directory

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir, "*.java")) {
            for (Path path : dirStream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to read the directory: " + e.getMessage());
        }
    }
}