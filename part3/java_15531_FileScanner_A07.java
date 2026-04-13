import java.io.*;
import java.nio.file.*;

public class java_15531_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String SECRET = "secret";

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(DIRECTORY);
        FileVisitor<Path> visitor = new SecureFileVisitor(dir, SECRET);
        Files.walkFileTree(dir, visitor);
    }
}

class SecureFileVisitor extends SimpleFileVisitor<Path> {
    private final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
    private final String secret;

    SecureFileVisitor(Path dir, String secret) {
        this.secret = secret;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!matcher.matches(file.getFileName())) {
            return FileVisitResult.CONTINUE;
        }

        byte[] secretBytes = secret.getBytes();
        byte[] fileContentBytes = Files.readAllBytes(file);

        for (int i = 0; i < fileContentBytes.length; i++) {
            fileContentBytes[i] ^= secretBytes[i % secretBytes.length];
        }

        Path newFile = file.getFileName();
        Files.write(newFile, fileContentBytes);

        return FileVisitResult.CONTINUE;
    }
}