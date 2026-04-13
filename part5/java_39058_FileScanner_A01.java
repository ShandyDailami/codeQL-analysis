import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_39058_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".txt"))
                .forEach(FileScanner::printPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}