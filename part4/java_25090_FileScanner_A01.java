import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecureRandom;

public class java_25090_FileScanner_A01 {

    private static final SecureRandom random = new SecureRandom();

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) throws Exception {
        String[] fileNames = { "file1.txt", "file2.txt", "file3.txt" };
        String content = "This is the content of the file";

        for (String fileName : fileNames) {
            Path path = Paths.get(fileName);
            File file = new File(fileName);

            if (file.createNewFile()) {
                Files.write(path, content.getBytes());
                System.out.println("Created file: " + fileName);
            } else {
                System.out.println("File already exists: " + fileName);
            }

            try {
                startScan(path);
            } catch (Exception e) {
                System.out.println("Failed to scan file: " + fileName);
                e.printStackTrace();
            }
        }
    }

    private static void startScan(Path path) throws Exception {
        if (!Files.exists(path)) {
            throw new Exception("File does not exist: " + path);
        }

        FileVisitResult visitResult;

        do {
            visitResult = Files.walkFileTree(path, new MyFileVisitor(path));
        } while (visitResult == FileVisitResult.CONTINUE && !path.toFile().isDirectory());

        if (visitResult == FileVisitResult.TERMINATED) {
            System.out.println("Scan completed successfully");
        } else {
            throw new Exception("Failed to scan file: " + path);
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {

        private final Path startDirectory;

        public java_25090_FileScanner_A01(Path startDirectory) {
            this.startDirectory = startDirectory;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String fileName = file.toString();
            if (fileName.startsWith(startDirectory.toString()) &&
                !fileName.endsWith("file1.txt")) {
                String content = new String(Files.readAllBytes(file));
                System.out.println("Content in file: " + content);
                return FileVisitResult.CONTINUE;
            } else {
                return FileVisitResult.TERMINATE;
            }
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Failed to visit file: " + file.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}