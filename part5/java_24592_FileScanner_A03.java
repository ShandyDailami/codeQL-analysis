import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class java_24592_FileScanner_A03 {
    private Set<String> knownInjectionSequences = new HashSet<String>() {{
        add("DROP TABLE");
        add("DELETE FROM");
        // add more known injection sequences if needed
    }};

    public static void main(String[] args) throws Exception {
        FileScanner scanner = new SensitiveFileScanner();
        scanner.scanDirectory("/path/to/directory");
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        try (FileVisitor<Path> fileVisitor = new FileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitResult result;
                String content = new String(Files.readAllBytes(file.toAbsolutePath()));

                // Check for injection sequences
                for (String sequence : knownInjectionSequences) {
                    if (content.contains(sequence)) {
                        System.out.println("Detected injection in file: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                }

                // Continue the visit
                result = FileVisitResult.CONTINUE;
                return result;
            }

            @Override
            public FileVisitResult visitSymlink(Path symlink, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        }) {
            Files.walkFileTree(directory.toPath(), fileVisitor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}