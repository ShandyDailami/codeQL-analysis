import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_04428_FileScanner_A01 {

    private static final String ROOT_DIRECTORY = "./";

    public static void main(String[] args) {
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get(ROOT_DIRECTORY))) {
            for (Path dir : dirs) {
                if (Files.isDirectory(dir)) {
                    searchDirectory(dir);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchDirectory(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*.{txt,log}")) {
            for (Path file : files) {
                if (Files.isRegularFile(file)) {
                    processFile(file);
                }
            }
        } catch (IOException e) {
            System.out.println("Error processing file: " + file.toString() + ". Reason: " + e.getMessage());
        }
    }

    private static void processFile(Path file) {
        // TODO: Implement security-sensitive operations related to A01_BrokenAccessControl
        // For example, check the file permissions, compare with a known bad file, etc.

        System.out.println("Processing file: " + file.toString());
    }
}