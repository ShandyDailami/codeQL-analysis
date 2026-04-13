import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Pattern;

public class java_06327_FileScanner_A01 {
    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{1,32}$");

    public static void main(String[] args) throws IOException {
        Path rootDirectory = Paths.get("./"); // Change this to your root directory
        String fileNamePattern = ".*"; // Change this to your file name pattern

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(rootDirectory)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path) || !FILE_NAME_PATTERN.matcher(path.getFileName().toString()).matches()) {
                    continue;
                }

                if (matchFileNamePattern(path, fileNamePattern)) {
                    readFile(path);
                }
            }
        }
    }

    private static boolean matchFileNamePattern(Path path, String fileNamePattern) {
        return FILE_NAME_PATTERN.matcher(path.getFileName().toString()).matches();
    }

    private static void readFile(Path path) throws IOException {
        try (InputStream inputStream = Files.newInputStream(path)) {
            // Read file content here
        }
    }
}