import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.*;

public class java_34183_FileScanner_A08 {
    private FileMatcher matcher;

    public java_34183_FileScanner_A08(String directory, String pattern) {
        Path dir = Paths.get(directory);
        this.matcher = dir.resolve(Paths.get(pattern)).iterator();
    }

    public void scan(Path startingPath) {
        try {
            Files.walkFileTree(startingPath, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileVisitResult result;
                    String name = file.toString();
                    if (matcher.matches(name)) {
                        System.out.println("Found file: " + name);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileScanner(".", "*.java").scan(Paths.get("."));
    }
}