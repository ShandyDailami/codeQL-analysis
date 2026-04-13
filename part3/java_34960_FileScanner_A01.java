import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_34960_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get(".");
        System.out.println("Scanning starting directory: " + startingDir);

        FileVisitResult result = visit(startingDir, path -> {
            BasicFileAttributes attrs;
            try {
                attrs = Files.readAttributes(path, BasicFileAttributes.class);
            } catch (IOException e) {
                return FileVisitResult.CONTINUE;
            }

            // Only allow files and directories that are not executable or hidden
            if (!Files.isRegularFile(path) || Files.isHidden(path)) {
                return FileVisitResult.CONTINUE;
            }

            // Only allow .txt files
            if (!path.toString().endsWith(".txt")) {
                return FileVisitResult.CONTINUE;
            }

            // Check file permissions
            long permissions = Files.getPosixFileAttributeView(path, false).readAttributes().permissions();
            if ((permissions & 0x8000) != 0) {
                return FileVisitResult.CONTINUE;
            }

            // Permission is fine
            return FileVisitResult.CONTINUE;
        });

        if (result.equals(FileVisitResult.TERMINATED)) {
            System.out.println("Scan completed.");
        }
    }

    public static FileVisitResult visit(Path path, java.nio.file.FileVisitor.BeforeVisitDirectory<Path> beforeVisitDirectory) throws IOException {
        FileVisitResult result;
        if (beforeVisitDirectory != null) {
            result = beforeVisitDirectory.evaluate(path);
        } else {
            result = FileVisitResult.CONTINUE;
        }

        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            try {
                Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        FileVisitResult result;
                        if (beforeVisitDirectory != null) {
                            result = beforeVisitDirectory.evaluate(file);
                        } else {
                            result = FileVisitResult.CONTINUE;
                        }

                        if (result.equals(FileVisitResult.CONTINUE)) {
                            if (Files.isRegularFile(file) && Files.isHidden(file)) {
                                long permissions = Files.getPosixFileAttributeView(file, false).readAttributes().permissions();
                                if ((permissions & 0x8000) == 0) {
                                    System.out.println("File: " + file.toString() + " is a regular file and hidden, but permission is fine.");
                                }
                            }
                        }
                        return result;
                    }
                });
            } catch (IOException e) {
                throw new IOException("Error while walking the directory tree", e);
            }
        }
        return result;
    }
}