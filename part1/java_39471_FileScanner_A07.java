import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_39471_FileScanner_A07 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startPath = Paths.get(".").toAbsolutePath(); // replace with your directory
        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (isSecuritySensitive(file)) {
                    return FileVisitResult.CONTINUE;
                }

                // process file...
                System.out.println("Processing file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            private boolean isSecuritySensitive(Path file) {
                // add your security-sensitive operation here
                // for now, let's just check if the file name starts with A or a
                return file.getFileName().toString().startsWith("A");
            }
        });
    }
}