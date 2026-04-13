import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class java_23527_FileScanner_A03 {
    public static void main(String[] args) {
        // Define the directory and the extension
        String directory = "/path/to/your/directory";
        String extension = ".txt";

        // Create a list to store the file paths
        List<Path> filePaths = new ArrayList<>();

        // Try to initialize the file system
        try (FileSystems fileSystem = FileSystems.newFileSystem(Paths.get(directory), null)) {
            // Walk through the directory
            fileSystem.validated().walk(fileSystem.getPath(directory))
                    .filter(path -> path.toString().endsWith(extension))
                    .forEach(filePaths::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print the file paths
        for (Path path : filePaths) {
            System.out.println(path.toString());
        }
    }
}