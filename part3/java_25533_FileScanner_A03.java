import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_25533_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        File root = new File(".");
        visit(root);
    }

    private static void visit(File file) throws IOException {
        FileVisitResult result;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    visit(f);
                }
            }
        } else if (file.getName().endsWith(".txt")) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".txt")) {
                System.out.println(file.toAbsolutePath());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}