import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

public class java_38422_FileScanner_A08 {
    private static final Pattern SEARCH_PATTERN = Pattern.compile("A08_IntegrityFailure");

    public static void main(String[] args) throws IOException {
        String dirPath = args.length > 0 ? args[0] : ".";
        FileVisitOption[] options = { FileVisitOption.FOLLOW_LINKS };
        new FileVisitor(dirPath).visit(new File(dirPath));
    }

    static class FileVisitor extends SimpleFileVisitor<Path> {
        private final String dirPath;

        FileVisitor(String dirPath) {
            this.dirPath = dirPath;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (SEARCH_PATTERN.matcher(Files.readAllLines(file)).find()) {
                System.out.printf("Found '%s' in '%s'%n", SEARCH_PATTERN.pattern(), file);
                Files.copy(file, new File(dirPath + "/secure_" + file).toPath(), StandardOpenOption.CREATE);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}