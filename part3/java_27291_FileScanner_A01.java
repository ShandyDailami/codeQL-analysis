import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class java_27291_FileScanner_A01 {
    private static final String OUTPUT_FILE = "output.txt";
    private static final Set<String> BLOCKED_FILES = new HashSet<>();

    public static void main(String[] args) throws IOException {
        File rootDir = new File("path_to_your_root_directory");
        FileVisitor fileVisitor = new FileVisitorImpl();
        Files.walkFileTree(rootDir.toPath(), fileVisitor);
        Files.write(fileVisitor.getOutputFile().toPath(), fileVisitor.getBlockedFiles().toString().getBytes());
    }

    private static class FileVisitorImpl extends SimpleFileVisitor<Path> {
        private Set<String> blockedFiles = new HashSet<>();
        private File outputFile = new File(OUTPUT_FILE);

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (isBlocked(file.toFile())) {
                blockedFiles.add(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        private boolean isBlocked(File file) {
            // Implement your security-sensitive operations here
            // For instance, you can check if a file is blocked by checking if it's in a list of blocked files
            return BLOCKED_FILES.contains(file.getAbsolutePath());
        }

        public Set<String> getBlockedFiles() {
            return blockedFiles;
        }

        public File getOutputFile() {
            return outputFile;
        }
    }
}