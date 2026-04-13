import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class java_22160_FileScanner_A07 {
    private String targetDir;
    private String targetExt;
    private String targetOwner;

    public java_22160_FileScanner_A07(String targetDir, String targetExt, String targetOwner) {
        this.targetDir = targetDir;
        this.targetExt = targetExt;
        this.targetOwner = targetOwner;
    }

    public void scan() {
        try {
            Files.walkFileTree(Paths.get(targetDir), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.size(file) > 0 && file.getFileName().toString().endsWith(targetExt) && 
                        Files.getOwner(file).getName().equals(targetOwner)) {
                        System.out.println("File found: " + file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AuthFileScanner(".", ".txt", "owner").scan();
    }
}