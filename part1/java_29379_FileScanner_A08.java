import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_29379_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path directory = Paths.get("path_to_directory");
        String fileName = "file_name.ext";
        scanFile(directory, fileName);
    }

    private static void scanFile(Path directory, String fileName) throws IOException {
        try (Stream<Path> paths = Files.walk(directory)) {
            boolean foundFile = paths.anyMatch(path -> path.toString().endsWith(fileName));

            if (foundFile) {
                System.out.println("File found in directory: " + directory);
            } else {
                System.out.println("File not found in directory: " + directory);
            }
        }
    }
}