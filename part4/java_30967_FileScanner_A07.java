import java.io.File;
import java.nio.file.*;

public class java_30967_FileScanner_A07 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath().normalize();
        try (Stream<Path> dirStream = Files.walk(startingDirectory)) {
            dirStream.forEach(FileScannerLegacy::processPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processPath(Path path) {
        if (Files.isDirectory(path)) {
            System.out.println("Directory: " + path);
        } else if (Files.isRegularFile(path)) {
            System.out.println("Regular File: " + path);
        } else {
            System.out.println("Other: " + path);
        }
    }
}