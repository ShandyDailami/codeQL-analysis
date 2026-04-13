import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_31915_FileScanner_A01 {
    public static void main(String[] args) {
        String dirPath = "path_to_directory"; // replace with the path of the directory
        File file = new File(dirPath);
        if (!file.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(dirPath))) {
            paths.forEach(path -> {
                if (Files.isReadable(path)) {
                    System.out.println(path.toString());
                } else {
                    System.out.println("Cannot read file: " + path.toString());
                }
            });
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}