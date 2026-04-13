import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_39831_FileScanner_A07 {
    private static final String UNAUTHORIZED_WORD = "auth failure";

    public static void main(String[] args) throws IOException {
        File rootDirectory = new File(".");
        Files.walkFileTree(rootDirectory.toPath(), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                byte[] contents = Files.readAllBytes(file);
                if (checkForAuthFailure(contents)) {
                    System.out.println("Auth failure detected in: " + file);
                }
                return FileVisitResult.CONTINUE;
            }

            private boolean checkForAuthFailure(byte[] contents) {
                String content = new String(contents);
                return content.contains(UNAUTHORIZED_WORD);
            }
        });
    }
}