import java.nio.file.*;

public class java_01970_FileScanner_A03 {

    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get(".");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Unable to access: " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}