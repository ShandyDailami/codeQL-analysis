import java.nio.file.*;
import java.io.*;

public class java_23103_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get("."); // get current directory

        try (FileSystem fs = path.getFileSystem()) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}