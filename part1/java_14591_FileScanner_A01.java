import java.io.IOException;
import java.nio.file.*;

public class java_14591_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");
        try {
            Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) {
                        if (file.getFileName().toString().endsWith(".txt")) {
                            Files.lines(file)
                                 .forEach(System.out::println);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}