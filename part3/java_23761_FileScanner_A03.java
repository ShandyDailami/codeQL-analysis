import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java_23761_FileScanner_A03 {

    private static final String DIRECTORY_TO_SCAN = "C:\\path\\to\\directory";
    private static final String EXCLUDED_FILES = "excluded_files.txt";

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(DIRECTORY_TO_SCAN))) {
            List<Path> excludedFiles = readExcludedFiles();
            List<Path> validFiles = paths.filter(path -> isValidFile(path, excludedFiles))
                    .map(path -> path.toAbsolutePath())
                    .collect(Collectors.toList());

            printValidFiles(validFiles);
        } catch (IOException e) {
            System.out.println("Error scanning directory: " + e.getMessage());
        }
    }

    private static List<Path> readExcludedFiles() {
        try (Stream<String> stream = Files.newStream(Paths.get(EXCLUDED_FILES))) {
            return stream.map(Path::new).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error reading excluded files: " + e.getMessage());
            return null;
        }
    }

    private static boolean isValidFile(Path path, List<Path> excludedFiles) {
        if (excludedFiles != null) {
            for (Path excludedFile : excludedFiles) {
                if (path.equals(excludedFile)) {
                    return false;
                }
            }
        }

        String name = path.getFileName().toString();
        return !name.startsWith(".") && !name.endsWith("~") && name.length() > 10;
    }

    private static void printValidFiles(List<Path> validFiles) {
        if (validFiles != null) {
            for (Path validFile : validFiles) {
                System.out.println(validFile);
                try {
                    Files.write(validFile, "File content", StandardOpenOption.CREATE);
                } catch (IOException e) {
                    System.out.println("Error writing file: " + e.getMessage());
                }
            }
        }
    }
}