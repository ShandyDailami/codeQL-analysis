import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_41451_FileScanner_A08 {
    private static class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.toString());
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: FileScanner directory");
            System.exit(1);
        }

        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.err.println("Directory does not exist");
            System.exit(1);
        }

        Files.walkFileTree(directory.toPath(), new FileVisitor());
    }
}