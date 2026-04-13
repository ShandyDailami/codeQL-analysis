import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_31496_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        // Start the scan from the current directory
        Path startingDirectory = Paths.get(".");

        // Traverse all files in the directory
        Files.walk(startingDirectory)
            .filter(path -> !Files.isDirectory(path))
            .forEach(Main::printFileInfo);
    }

    private static void printFileInfo(Path path) throws IOException {
        // Get the file info
        File file = path.toFile();
        long size = Files.size(path);
        String name = file.getName();

        // Print the file info
        System.out.println(name + ": " + size + " bytes");
    }
}