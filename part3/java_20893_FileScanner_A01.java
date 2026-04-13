import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_20893_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        // Specify the directory path
        String directoryPath = "/path/to/directory";
        Files.walk(Paths.get(directoryPath))
            .map(Path::toFile)
            .forEach(file -> {
                if (file.isFile() && file.canRead()) {
                    System.out.println("File name: " + file.getName());
                }
            });
    }
}