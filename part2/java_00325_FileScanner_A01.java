import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_00325_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("."); // current directory

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileSystem fs = file.getFileSystem();
                FilePermission[] perms = fs.getFileStore().getFilePermission();

                // Check if file is readable
                if (perms[0].equals(FilePermission.delete())) {
                    System.out.println("Found a file that can be deleted. File path: " + file.toString());
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }
}