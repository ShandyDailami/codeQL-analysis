import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_17845_FileScanner_A07 {

    public static void main(String[] args) {
        File dir = new File(".");
        printFilesInDir(dir);
    }

    private static void printFilesInDir(File dir) {
        try {
            Files.walkFileTree(dir.toPath(), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println(file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}