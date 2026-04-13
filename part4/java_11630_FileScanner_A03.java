import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_11630_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.forEach(filePath -> {
                File file = filePath.toFile();
                if (file.isFile() && file.canRead()) {
                    System.out.println("Reading file: " + file.getAbsolutePath());
                    // TODO: Add your code here to read and process the file.
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}