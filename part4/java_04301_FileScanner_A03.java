import java.io.File;
import java.io.IOException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecurityManager;
import java.security.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class java_04301_FileScanner_A03 {
    private final SecurityManager securityManager;
    private final Pattern filePattern;
    private final File startDirectory;

    public java_04301_FileScanner_A03(File startDirectory, Pattern filePattern, SecurityManager securityManager) {
        this.startDirectory = startDirectory;
        this.filePattern = filePattern;
        this.securityManager = securityManager;
    }

    public List<File> scan() throws IOException {
        FileVisitor visitor = new FileVisitor(this.securityManager, this.filePattern, startDirectory);
        visitor.visit(startDirectory);
        return visitor.getFiles();
    }

    private static class FileVisitor extends java.nio.file.FileVisitor<Path> {
        private final SecurityManager securityManager;
        private final Pattern filePattern;
        private final Path startDirectory;
        private final List<File> files = new ArrayList<>();

        public java_04301_FileScanner_A03(SecurityManager securityManager, Pattern filePattern, Path startDirectory) {
            this.securityManager = securityManager;
            this.filePattern = filePattern;
            this.startDirectory = startDirectory;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            File newFile = file.toFile();
            if (filePattern.matcher(newFile.getName()).matches()) {
                if (securityManager.checkPermission(new FilePermission(newFile.getPath(), "read"))) {
                    files.add(newFile);
                }
            }
            return FileVisitResult.CONTINUE;
        }

        public List<File> getFiles() {
            return files;
        }
    }

    public static void main(String[] args) throws Exception {
        SecurityManager sm = new SecurityManager();
        File file = new File(".");
        FileScanner scanner = new FileScanner(file, Pattern.compile(".*"), sm);
        List<File> files = scanner.scan();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}