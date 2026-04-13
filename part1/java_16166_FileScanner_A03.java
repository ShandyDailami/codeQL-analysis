import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_16166_FileScanner_A03 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    scanDirectory(path);
                } else {
                    printFile(path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }

    private static void scanDirectory(Path directory) {
        System.out.println("Scanning directory: " + directory);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    scanDirectory(path);
                } else {
                    printFile(path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }

    private static void printFile(Path path) {
        System.out.println("Found file: " + path.toString());
    }
}