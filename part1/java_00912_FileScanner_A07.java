import java.nio.file.*;
import java.util.regex.Pattern;

public class java_00912_FileScanner_A07 {

    // Pattern for file names
    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("^pattern.*\.txt$");

    public static void main(String[] args) throws Exception {

        // Path to scan
        Path path = Paths.get(".");

        // File filter
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String name = file.getFileName().toString();
                if (FILE_NAME_PATTERN.matcher(name).matches()) {
                    // process file
                    System.out.println("Found file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}