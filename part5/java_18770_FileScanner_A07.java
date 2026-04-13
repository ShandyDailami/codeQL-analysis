import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_18770_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{ext}");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path dir : dirs) {
                FileVisitResult result;
                if ((result = Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        FileVisitorHelper.processFile(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                        System.err.println("Failed to access file: " + file);
                        return FileVisitResult.CONTINUE;
                    }
                })) == FileVisitResult.TERMINATE) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}