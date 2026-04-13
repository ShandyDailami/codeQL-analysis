import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.FileVisitOption;
import java.nio.file.attribute.BasicFileAttributes;

public class java_09102_FileScanner_A07 {
    public static void main(String[] args) {
        String dir = args.length > 0 ? args[0] : ".";

        try {
            Path start = Paths.get(dir);
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws FileNotFoundException {
                    String name = file.toString();
                    File f = new File(name);
                    if (f.isFile() && (name.endsWith(".java") || name.endsWith(".java.class"))) {
                        System.out.println("Found Java file: " + name);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}