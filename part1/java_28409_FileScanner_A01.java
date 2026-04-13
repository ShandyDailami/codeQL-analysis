import java.io.File;
import java.io.IOException;
import java.io.FileVisitor;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_28409_FileScanner_A01 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory"; // replace with your directory path
        FileVisitor<Path> fileVisitor = new java.io.FileVisitor<>() {
            @Override
            public boolean visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return true;
            }

            @Override
            public boolean visitFileFailed(Path file, IOException exc) {
                System.out.println("Failed to visit: " + file);
                return true;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("Finished visiting: " + dir);
                return FileVisitResult.CONTINUE;
            }
        };

        try {
            fileVisitor. visit(Paths.get(dirPath));
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + dirPath);
        } catch (IOException e) {
            System.out.println("Failed to visit: " + dirPath);
        }
    }
}