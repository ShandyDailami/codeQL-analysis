import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardVisitResult;

public class java_32243_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("src/main/resources");

        FileVisitor fileVisitor = new FileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found txt file: " + file.toString());
                }
                return StandardVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("Error accessing file: " + file.toString());
                return StandardVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return StandardVisitResult.CONTINUE;
            }
        };

        try {
            java.nio.file.Files.walkFileTree(directory.toPath(), fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}