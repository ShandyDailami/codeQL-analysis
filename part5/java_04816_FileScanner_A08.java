import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_04816_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(".");

        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    try {
                        FileOperationUtils.readFile(file);
                    } catch (IOException e) {
                        System.out.println("Security file detected: " + file.toString());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    static class FileOperationUtils {
        static void readFile(Path file) throws IOException {
            FileInputStream fis = new FileInputStream(file.toString());
            // Attempt to read file, if successful, do nothing (security violation)
            fis.read();
            fis.close();
        }
    }
}