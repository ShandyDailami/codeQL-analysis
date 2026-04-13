import java.nio.file.*;
import java.util.stream.*;

public class java_16469_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("."); // Current directory
        try (Stream<Path> paths = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            paths.forEach(file -> {
                if (Files.isRegularFile(file)) {
                    System.out.println("Regular file: " + file.getFileName());
                } else if (Files.isDirectory(file)) {
                    System.out.println("Directory: " + file.getFileName());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}