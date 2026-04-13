import java.io.*;
import java.nio.file.*;

public class java_03241_FileScanner_A07 {
    private static final String DIRECTORY = "src/main/java/";

    public static void main(String[] args) throws IOException {
        Path directory = Paths.get(DIRECTORY);

        Files.walkFileTree(directory, new SimpleFileVisitor<>()) {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileNameMatcher matcher = FileSystems.getDefault().getFileStore(file.toString()).match("*.java");
                if (matcher.matches()) {
                    FileName filename = matcher.getName();
                    System.out.println("Found .java file: " + filename);
                }
                return FileVisitResult.CONTINUE;
            }
        };
    }
}