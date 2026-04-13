import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_07407_FileScanner_A01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDir = Paths.get("."); // Set this to the directory you want to start scanning from
        String fileName = "example.txt"; // Set this to the file name you are looking for

        Files.walkFileTree(startingDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().equals(fileName)) {
                    System.out.println("Found file: " + file.toString());
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}