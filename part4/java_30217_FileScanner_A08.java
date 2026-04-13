import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class java_30217_FileScanner_A08 implements FileVisitor<Path> {
    private String fileToFind;

    public java_30217_FileScanner_A08(String fileToFind) {
        this.fileToFind = fileToFind;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(fileToFind)) {
            System.out.println("File found: " + file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws Exception {
        File rootDir = new File(".");
        String fileToFind = ".java";
        FileScanner fileScanner = new FileScanner(fileToFind);
        rootDir.getAbsoluteFile().forEachFile(fileScanner);
    }
}