import java.nio.file.*;
import java.io.*;

public class java_08273_FileScanner_A03 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(".");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitor.Default result = super.visitFile(file, attrs);
                FileNameHelper helper = new FileNameHelper(file.toString());
                if (helper.isJavaSourceFile(file)) {
                    System.out.println("Visited file: " + file);
                }
                return result;
            }
        });
    }

    static class FileNameHelper {
        private final String filename;

        public java_08273_FileScanner_A03(String filename) {
            this.filename = filename;
        }

        public boolean isJavaSourceFile(Path path) throws IOException {
            String name = path.getFileName().toString();
            return isJavaSourceFile(name);
        }

        public boolean isJavaSourceFile(String name) {
            int lastDot = name.lastIndexOf('.');
            if (lastDot == -1) {
                return false;
            }
            String extension = name.substring(lastDot + 1);
            return "java".equalsIgnoreCase(extension);
        }
    }
}