import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class java_21535_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("."); // get the current directory
        listFiles(dir, true);
    }

    public static void listFiles(Path dir, boolean hidden) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<>(hidden));
    }

    static class SimpleFileVisitor extends SimpleFileVisitor<Path> {
        boolean hidden;

        public java_21535_FileScanner_A08(boolean hidden) {
            this.hidden = hidden;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (hidden && file.toString().startsWith("."))
                return FileVisitResult.CONTINUE;
            System.out.println(file.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}