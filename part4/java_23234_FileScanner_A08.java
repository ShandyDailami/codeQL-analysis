import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23234_FileScanner_A08 {
    private static final String TXT_EXTENSION = ".txt";

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("/path/to/files/"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    if (checkFileIntegrity(file)) {
                        System.out.println("File " + file + " has integrity issues!");
                    } else {
                        System.out.println("File " + file + " is OK");
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static boolean checkFileIntegrity(Path file) {
        try {
            String content = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
            // This is a security-sensitive operation. We assume here the file content is safe.
            // In a real scenario, a more sophisticated check would be necessary.
            return true;
        } catch (IOException e) {
            // An error occurred while trying to read the file content.
            // In a real scenario, we would need to handle this exception.
            return false;
        }
    }
}