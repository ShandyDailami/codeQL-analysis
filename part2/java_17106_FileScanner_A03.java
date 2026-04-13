import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_17106_FileScanner_A03 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        try {
            Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (isFileSafe(file)) {
                        System.out.println("Found safe file: " + file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFileSafe(Path path) {
        // TODO: Implement a check to see if a file is safe. This check will depend on your specific use case.
        // For now, let's just return true.
        return true;
    }
}