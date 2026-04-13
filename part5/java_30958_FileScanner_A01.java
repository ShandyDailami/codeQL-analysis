import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_30958_FileScanner_A01 {

    public static void main(String[] args) {

        Path startingDirectory = Paths.get(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found a .txt file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(startingDirectory, fileVisitor);
    }
}