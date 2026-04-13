import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_38091_FileScanner_A08 {

    public static void main(String[] args) {
        File directory = new File("path_to_directory");
        FileVisitor visitor = new FileVisitor();

        try {
            Files.walkFileTree(directory.toPath(), visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }
}