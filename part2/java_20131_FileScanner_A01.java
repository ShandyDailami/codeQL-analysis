import java.io.IOException;
import java.nio.file.*;

public class java_20131_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingPath, "*.java")) {
            for (Path path : dirs) {
                FileVisitResult result;
                try {
                    result = Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            System.out.println("Found java file: " + file.toAbsolutePath());
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                            System.err.println("Failed to visit file: " + file.toAbsolutePath());
                            return FileVisitResult.CONTINUE;
                        }
                    });

                    if (result == FileVisitResult.TERMINATE) {
                        System.out.println("Terminated early");
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}