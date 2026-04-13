import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_32785_FileScanner_A07 {

    private static final String[] SENSITIVE_FILE_EXTENSIONS = { ".pdf", ".docx", ".xlsx", ".png", ".jpg", ".jpeg", ".gif", ".txt" };

    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        try {
            Files.walkFileTree(Paths.get(dirPath), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String name = file.getFileName().toString();
            for (String ext : SENSITIVE_FILE_EXTENSIONS) {
                if (name.toLowerCase().endsWith(ext)) {
                    // File is a sensitive file, so we skip it
                    return FileVisitResult.SKIP_SIBLINGS;
                }
            }
            // File is not a sensitive file, so we print it
            System.out.println(file.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}