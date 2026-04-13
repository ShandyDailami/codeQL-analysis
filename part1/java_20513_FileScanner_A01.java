import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_20513_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        Path directory = Paths.get(".");
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String fileName = file.toString();
                System.out.println("File name: " + fileName);
                try (BufferedReader reader = Files.newBufferedReader(file)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Content: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Failed to read file: " + fileName);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}