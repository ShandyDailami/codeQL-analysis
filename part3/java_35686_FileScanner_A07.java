import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_35686_FileScanner_A07 {

    private static final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

    public static void main(String[] args) throws Exception {
        Path root = FileSystems.getDefault().getRootDirectories().iterator().next();
        System.out.println("Searching in: " + root);

        Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("File found: " + file);

                    // Perform security-sensitive operations related to A07_AuthFailure
                    // ...

                    // Optional: read file and print the content
                    try (BufferedReader reader = Files.newBufferedReader(file)) {
                        reader.lines().forEach(System.out::println);
                    }

                    System.out.println("----------------------");
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}