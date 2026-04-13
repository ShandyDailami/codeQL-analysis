import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23732_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        File rootDirectory = new File("/path/to/directory");
        visitDirectory(rootDirectory);
    }

    private static void visitDirectory(File directory) throws IOException {
        Files.walkFileTree(directory.toPath(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                File fileObj = file.toFile();
                if (fileObj.canRead() && fileObj.isFile() && fileObj.isExecutable()) {
                    System.out.println(fileObj.getAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}