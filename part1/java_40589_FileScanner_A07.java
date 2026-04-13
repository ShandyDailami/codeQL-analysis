import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_40589_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/path/to/directory");

        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                boolean secureOperation = isSecureOperation(file);

                if (secureOperation) {
                    System.out.println("Secure operation performed on: " + file);
                } else {
                    System.out.println("Non-secure operation performed on: " + file);
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static boolean isSecureOperation(Path file) {
        // Here you can perform any security-sensitive operations related to authentication failure
        // For this example, let's say we assume a file is secure if its last modification time is in the past
        long currentTime = System.currentTimeMillis();
        long lastModifiedTime = file.getFileAttributeView(FileAttributes.class).readAttributes().lastModifiedTime().toMillis();

        return currentTime - lastModifiedTime > 10000; // 10 seconds
    }
}