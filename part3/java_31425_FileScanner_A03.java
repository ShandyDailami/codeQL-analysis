import java.io.IOException;
import java.nio.file.*;

public class java_31425_FileScanner_A03 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get("./src/main/java");

        try (FileSystem fs = startingDirectory.getFileSystem()) {
            Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isReadable(file)) {
                        System.out.println("Reading file: " + file.toString());
                    } else {
                        System.err.println("Error: cannot read file " + file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error: cannot read directory " + startingDirectory.toString());
            e.printStackTrace();
        }
    }
}