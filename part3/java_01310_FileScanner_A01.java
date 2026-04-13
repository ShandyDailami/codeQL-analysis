import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.AttributeView;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.AccessDeniedException;

public class java_01310_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (PrintWriter out = new PrintWriter("output.txt")) {
            new FileVisitor(directory).visit(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FileVisitor extends SimpleFileVisitor<Path> {
        private final PrintWriter out;

        FileVisitor(File directory) {
            this.out = new PrintWriter("output.txt");
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            try {
                // Access file without user's permission
                if (Files.isReadable(file) && !Files.isWritable(file) && !Files.isExecutable(file)) {
                    out.println(file.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            // Log the failure and continue.
            System.err.println(file + ": " + exc);
            return FileVisitResult.CONTINUE;
        }
    }
}