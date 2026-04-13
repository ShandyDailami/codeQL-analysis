import java.io.*;
import java.nio.file.*;

public class java_38226_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/directory";
    private static final String SECRET_FILE_EXTENSION = ".secret";

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(DIR_PATH);
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String name = file.getFileName().toString();
                if (name.endsWith(SECRET_FILE_EXTENSION)) {
                    // Sensitive operations related to A07_AuthFailure
                    // ...

                    // Print file name and size
                    System.out.println("File: " + name + ", Size: " + Files.size(file));
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}