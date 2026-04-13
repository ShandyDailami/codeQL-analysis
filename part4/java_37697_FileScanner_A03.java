import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_37697_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        new FileVisitor().visit(new File(directory));
    }

    class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String content = new String(Files.readAllBytes(file));
            // check for injection attempts here, e.g.
            if (content.contains("drop table")) {
                System.out.println("Detected injection attempt: " + file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}