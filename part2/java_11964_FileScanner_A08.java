import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;

public class java_11964_FileScanner_A08 {
    private static final Pattern FILE_PATTERN = Pattern.compile(".*\\.(java)$");

    public static void main(String[] args) {
        String dir = "path/to/directory";

        try {
            Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (FILE_PATTERN.matcher(file.getFileName().toString()).matches()) {
                        System.out.println("File found: " + file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}