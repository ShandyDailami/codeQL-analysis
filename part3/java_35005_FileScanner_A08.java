import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;

public class java_35005_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        FileVisitor fileVisitor = new FileVisitor();

        try {
            Files.walkFileTree(file.toPath(), fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileVisitResult result = super.visitFile(file, attrs);

        // This is a placeholder for the actual code that checks integrity.
        // For the purpose of this example, we'll just print the file name.
        if (file.toString().contains("A08_IntegrityFailure")) {
            System.out.println("Found file with integrity failure: " + file.toString());
            // Open the file for writing, create it if it doesn't exist, and append to it
            Files.write(file, "Integrity failure detected".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }

        return result;
    }
}