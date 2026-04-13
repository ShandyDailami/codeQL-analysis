import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_07073_FileScanner_A07 {
    private static final String DIRECTORY_TO_SCAN = "C:\\path_to_directory"; // Specify your directory here
    private static final String FILE_EXTENSION = "txt"; // Specify the file extension here

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_TO_SCAN);
        FileFilter fileFilter = (File pathname) -> pathname.getName().endsWith(FILE_EXTENSION);

        try (Stream<Path> stream = Files.walk(Paths.get(DIRECTORY_TO_SCAN))) {
            stream.filter(path -> Files.isRegularFile(path) && fileFilter.accept(path.toFile()))
                    .forEach(FileScanner::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        // Handle the file here, such as reading the file, processing it, etc.
        System.out.println("Processing file: " + path);
    }
}