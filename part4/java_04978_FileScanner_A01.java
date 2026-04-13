import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java_04978_FileScanner_A01 {

    private static final String DIRECTORY = "/path/to/directory";
    private static final String EXTENSION = ".txt";
    private static final int SIZE = 1024; // in bytes

    public static void main(String[] args) throws IOException {
        List<Path> fileList = getFileList(DIRECTORY);
        List<Path> filteredFiles = filterFiles(fileList, EXTENSION, SIZE);

        for (Path path : filteredFiles) {
            System.out.println(path);
        }
    }

    private static List<Path> getFileList(String directory) {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            return paths.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
            return null;
        }
    }

    private static List<Path> filterFiles(List<Path> fileList, String extension, int size) {
        return fileList.stream()
                .filter(path -> path.toString().endsWith(extension))
                .filter(path -> Files.size(path) >= size)
                .collect(Collectors.toList());
    }
}