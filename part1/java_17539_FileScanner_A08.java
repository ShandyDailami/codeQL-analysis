import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_17539_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        long lineCount = countLinesInDirectory(directoryPath);
        System.out.println("Number of lines in all files: " + lineCount);
    }

    public static long countLinesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        long lineCount = 0;

        try (Stream<Path> paths = Files.list(Paths.get(directoryPath))) {
            lineCount = paths
                    .flatMap(FileScanner::findFilesInDirectory)
                    .mapToLong(FileScanner::countLinesInFile)
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineCount;
    }

    private static Stream<Path> findFilesInDirectory(Path path) {
        try {
            return Files.find(path, 10, (p, a) -> Files.isRegularFile(p));
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

    private static long countLinesInFile(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.count();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}