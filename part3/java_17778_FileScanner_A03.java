import java.nio.file.*;
import java.util.regex.Pattern;

public class java_17778_FileScanner_A03 {
    private static final Pattern FILE_EXTENSION_PATTERN = Pattern.compile(".*\\.([^\\.]*)$");

    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        Files.walk(startingDirectory)
            .filter(path -> !Files.isDirectory(path))
            .filter(FileScanner::isFileWithSupportedExtension)
            .forEach(FileScanner::processFile);
    }

    private static boolean isFileWithSupportedExtension(Path path) {
        String name = path.getFileName().toString();
        return FILE_EXTENSION_PATTERN.matcher(name).matches();
    }

    private static void processFile(Path path) {
        System.out.println("Processing file: " + path.toString());
        // TODO: implement file processing logic here
    }
}