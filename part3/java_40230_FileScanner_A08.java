import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_40230_FileScanner_A08 {
    private static final Set<String> INTEGRITY_FAILURE_FILE_EXTENSIONS = new HashSet<>(Arrays.asList(".log", ".err", ".xml"));
    private static final String INTEGRITY_FAILURE_DIRECTORY = "/path/to/integrity/failure/directory";

    public static void main(String[] args) throws IOException {
        File rootDirectory = new File(INTEGRITY_FAILURE_DIRECTORY);
        new FileVisitor().visit(rootDirectory);
    }

    private static class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (isIntegrityFailureFile(file.toFile())) {
                Files.copy(file, new File("integrity_failure.log").toPath(), StandardOpenOption.CREATE);
            }
            return FileVisitResult.CONTINUE;
        }

        private boolean isIntegrityFailureFile(File file) {
            String name = file.getName();
            return INTEGRITY_FAILURE_FILE_EXTENSIONS.stream()
                    .anyMatch(ext -> name.toLowerCase().endsWith(ext));
        }
    }
}