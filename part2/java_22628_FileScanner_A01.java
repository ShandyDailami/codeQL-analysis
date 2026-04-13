import java.nio.file.*;

public class java_22628_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Processing file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}