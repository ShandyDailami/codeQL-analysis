import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_10417_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        try {
            Files.walkFileTree(directory.toPath(), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Reading file: " + file.toString());
                    StringBuilder content = new StringBuilder((int) attrs.size());
                    Files.readAllLines(file).forEach(line -> content.append(line).append("\n"));
                    System.out.println(content);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}