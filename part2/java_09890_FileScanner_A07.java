import java.nio.file.*;
import java.util.stream.*;

public class java_09890_FileScanner_A07 {

    // Define the directory where the files are located
    private static final String DIRECTORY_PATH = "path/to/directory";

    // Define the specific file names we are looking for
    private static final String[] FILENAMES_TO_FIND = {"file1.txt", "file2.txt"};

    public static void main(String[] args) {
        try {
            // Get a stream of all files in the directory
            Stream<Path> pathStream = Files.list(Paths.get(DIRECTORY_PATH))
                    .filter(Files::isRegularFile) // only files
                    .filter(path -> Arrays.stream(FILENAMES_TO_FIND).anyMatch(name -> path.getFileName().toString().equals(name))); // only the specified files

            // Print the names of the files that match the specified names
            pathStream.forEach(path -> System.out.println("Matched file: " + path.getFileName()));

        } catch (Exception e) {
            // Handle any potential errors
            System.out.println("Error scanning directory: " + e.getMessage());
        }
    }
}