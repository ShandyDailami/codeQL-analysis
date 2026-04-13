import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_31405_FileScanner_A01 {
    private static final PathMatcher<Path> FILE_EXAMINER = FileSystems.getDefault().getPathMatcher("glob:**/*.java");
    private static final String[] ALLOWED_PATTERNS = new String[] { "**/A01_*.java", "**/A02_*.java" };

    public static void main(String[] args) throws IOException, InterruptedException {
        Path start = Paths.get("src/main/java");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (FILE_EXAMINER.matches(file.getFileName()) && !isAllowed(file.getFileName().toString())) {
                    System.out.println("Broken access control: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static boolean isAllowed(String fileName) {
        for (String pattern : ALLOWED_PATTERNS) {
            if (FILE_EXAMINER.matches(Paths.get(pattern), fileName)) {
                return true;
            }
        }
        return false;
    }
}