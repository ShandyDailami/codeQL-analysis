import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_36032_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        try (Stream<Path> paths = Files.list(Paths.get(directoryPath))) {
            paths.forEach(path -> {
                File file = path.toFile();
                if (file.isFile()) {
                    try {
                        long size = Files.size(file.toPath());
                        System.out.println("File: " + file.getName() + ", Size: " + size + " bytes");
                    } catch (IOException e) {
                        System.out.println("Failed to get file size for: " + file.getName());
                    }
                }
            });
        } catch (IOException e) {
            System.out.println("Failed to list files in directory: " + directoryPath);
        }
    }
}