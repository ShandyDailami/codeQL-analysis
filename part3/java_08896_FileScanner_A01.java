import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_08896_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get("."); // Use current directory as the root path
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileSystem fs = file.getFileSystem();
                    // Perform security-sensitive operations related to A01_BrokenAccessControl
                    // In this case, we're checking if the file is readable
                    if (!Files.isReadable(file)) {
                        System.out.println("Security alert: File " + file.toString() + " is not readable.");
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}