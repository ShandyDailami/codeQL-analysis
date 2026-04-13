import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_17405_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("./src/main/java/");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(file)) {
                    System.out.println("Reading file: " + file);
                    // Here you can add your code to read and process the file
                    // For example, let's read the file and print its content
                    try (BufferedReader reader = Files.newBufferedReader(file)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}