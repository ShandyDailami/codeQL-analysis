import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class java_38508_FileScanner_A03 {

    private static final int MAX_FILE_SIZE = 1024; // 1024 bytes = 1 KB
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>();

    static {
        ALLOWED_EXTENSIONS.add(".txt");
        ALLOWED_EXTENSIONS.add(".java");
    }

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        long maxFileSize = MAX_FILE_SIZE;

        SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws java.io.IOException {
                File fileToCheck = file.toFile();
                if (fileToCheck.isFile() && fileToCheck.length() < maxFileSize && ALLOWED_EXTENSIONS.contains(fileToCheck.getName().substring(fileToCheck.getName().lastIndexOf(".") + 1))) {
                    System.out.println("File: " + fileToCheck.getAbsolutePath() + " has size " + fileToCheck.length() + " bytes");
                }
                return FileVisitResult.CONTINUE;
            }
        };

        rootDirectory.walkFileTree(fileVisitor);
    }
}