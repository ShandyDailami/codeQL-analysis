import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_08900_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            Stream<Path> paths = directoryStream.parallel().filter(FileScanner::isNotExecutable);
            paths.forEach(FileScanner::printPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNotExecutable(Path path) {
        return Files.isExecutable(path) == false;
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}