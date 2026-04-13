import java.io.IOException;
import java.nio.file.*;

public class java_13357_FileScanner_A08 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get("C:/directory_to_scan");
        try {
            Files.walkFileTree(startingDirectory, new SimpleFileVisitor<>()) {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Found file: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Unable to access file: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}