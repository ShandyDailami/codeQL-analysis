import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_41121_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        // use lambda expression to create file filter
        FileFilter fileFilter = (File pathname) -> {
            // skip directories
            if (Files.isDirectory(Path.of(pathname.getPath()))) {
                return false;
            }

            // check if the file is a text file
            if (Files.isRegularFile(Path.of(pathname.getPath())) && pathname.getName().endsWith(".txt")) {
                return true;
            }

            return false;
        };

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(path -> Files.not(fileFilter).test(path))
                .forEach(path -> System.out.println("File: " + path.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}