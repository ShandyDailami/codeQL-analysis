import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_23337_FileScanner_A03 {
    private static final String FILE_PATH = "src/main/resources/";
    private static final String FILE_FILTER = "*.java";

    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get(FILE_PATH), new SimpleFileVisitor<>(), 8, FileVisitOption.FOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class SimpleFileVisitor extends SimpleFileVisitor<Path> {
        private Set<String> classes = new HashSet<>();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                classes.add(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        public Set<String> getClasses() {
            return classes;
        }
    }
}