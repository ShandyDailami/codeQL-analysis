import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;

public class java_06861_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        String dirPath = "."; // The directory to start scanning from.

        Files.walkFileTree(Path.of(dirPath), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    Files.copy(file, Path.of("./", file.getFileName() + ".bak"), StandardOpenOption.CREATE);
                    System.out.println("Backup created for: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}