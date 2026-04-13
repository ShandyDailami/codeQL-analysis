import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class java_40469_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        Path startPath = Paths.get("C:/Temp");  // replace with your directory

        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String name = file.getFileName().toString();
                if (name.endsWith(".txt")) {
                    System.out.println("Found file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

}