import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_24609_FileScanner_A08 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        try {
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().toString().contains("A08_IntegrityFailure")) {
                        System.out.println("Found file: " + file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.println("Error accessing file: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}