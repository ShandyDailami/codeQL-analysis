import java.io.IOException;
import java.nio.file.*;

public class java_38527_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Path start = Paths.get("."); // start from current directory
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isReadable(file)) {
                        System.out.println(file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Unable to access: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}