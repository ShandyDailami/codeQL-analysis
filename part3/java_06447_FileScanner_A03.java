import java.nio.file.*;
import java.util.*;

public class java_06447_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");
        String fileName = "A03_Injection.txt";

        try {
            Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().toString().equals(fileName)) {
                        System.out.println("File found: " + file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}