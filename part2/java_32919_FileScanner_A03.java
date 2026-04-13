import java.io.File;
import java.io.FilenameFilter;
import java.io.FileVisitOption;
import java.io.FileVisitor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

public class java_32919_FileScanner_A03 {
    private final Pattern pattern;

    public java_32919_FileScanner_A03(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public void scan(String directoryPath) throws IOException {
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(file)) {
                    String filePathStr = file.toString();
                    if (pattern.matcher(filePathStr).matches()) {
                        // Add your security-sensitive operations here, e.g., checking for injection attacks
                        System.out.println("Security-sensitive operation: " + filePathStr);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(new File(directoryPath).toPath(), visitor, null, FileVisitOption.FOLLOW_LINKS);
    }

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner("pattern-to-match-in-filepaths");
        scanner.scan("directory-path-to-scan");
    }
}